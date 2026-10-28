package lab.events

import java.time.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

class EventServiceTest {

    private val base = Instant.parse("2024-03-01T09:00:00Z")

    // ids 1..25 in order; events 10-12 and 20-22 share a timestamp
    private val seed: List<Event> = (1L..25L).map { id ->
        val slot = when (id) {
            in 10L..12L -> 10L
            in 20L..22L -> 20L
            else -> id
        }
        Event(id, base.plusSeconds(slot), "order.updated")
    }

    private val service = EventService(EventRepository(seed))

    @Test
    fun pagesTogetherContainEveryEvent() {
        val collected = mutableListOf<Event>()
        var cursor: String? = null
        do {
            val page = service.list(cursor, 10)
            collected += page.items
            cursor = page.nextCursor
        } while (cursor != null)

        assertEquals(25, collected.size)
        assertEquals(seed.map { it.id }, collected.map { it.id })
    }

    @Test
    fun firstPageHasRequestedSize() {
        val page = service.list(null, 10)

        assertEquals(10, page.items.size)
        assertEquals((1L..10L).toList(), page.items.map { it.id })
    }
}
