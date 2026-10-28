package lab.webhook

import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WebhookHandlerTest {

    private val pending = PendingPayments()
    private val ledger = Ledger()
    private val event = WebhookEvent(id = "evt-1", accountId = "acc-1", amountCents = 500)

    @Test
    fun concurrentDeliveryOfSameEventCreditsOnce() {
        pending.put(event.id, event.amountCents)
        val handler = WebhookHandler(SteppedEventStore(), pending, ledger)

        deliverTwiceInParallel(handler, event)

        assertEquals(500L, ledger.balance("acc-1"))
    }

    @Test
    fun singleDeliveryCreditsTheAccount() {
        val store = InMemoryProcessedEventStore()
        pending.put(event.id, event.amountCents)

        WebhookHandler(store, pending, ledger).handle(event)

        assertEquals(500L, ledger.balance("acc-1"))
        assertTrue(store.exists(event.id))
    }

    private fun deliverTwiceInParallel(handler: WebhookHandler, event: WebhookEvent) {
        val pool = Executors.newFixedThreadPool(2)
        try {
            val deliveries = List(2) { pool.submit(Callable { handler.handle(event) }) }
            for (delivery in deliveries) {
                try {
                    delivery.get(5, TimeUnit.SECONDS)
                } catch (e: ExecutionException) {
                    throw e.cause ?: e
                }
            }
        } finally {
            pool.shutdownNow()
        }
    }

    /**
     * Fixes the order of two concurrent deliveries:
     * 1. Both deliveries call `exists` and read the current value.
     * 2. Neither returns from `exists` until both have read it.
     * 3. The first delivery to arrive returns at once and runs to `markProcessed`.
     * 4. The second delivery returns from `exists` only after that `markProcessed` call.
     */
    private class SteppedEventStore : ProcessedEventStore {

        private val ids = ConcurrentHashMap.newKeySet<String>()
        private var arrivals = 0
        private val bothChecked = CountDownLatch(2)
        private val firstMarked = CountDownLatch(1)

        override fun exists(id: String): Boolean {
            val seen = id in ids
            val position = synchronized(this) { ++arrivals }
            bothChecked.countDown()
            awaitOrFail(bothChecked)
            if (position == 2) awaitOrFail(firstMarked)
            return seen
        }

        override fun markProcessed(id: String) {
            ids.add(id)
            firstMarked.countDown()
        }

        private fun awaitOrFail(latch: CountDownLatch) {
            check(latch.await(5, TimeUnit.SECONDS)) { "timed out waiting for the other delivery" }
        }
    }
}
