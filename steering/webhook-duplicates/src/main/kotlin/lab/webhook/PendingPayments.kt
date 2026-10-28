package lab.webhook

import java.util.concurrent.ConcurrentHashMap

class PendingPayments(private val amounts: MutableMap<String, Long> = ConcurrentHashMap()) {

    fun put(id: String, amountCents: Long) {
        amounts[id] = amountCents
    }

    fun take(id: String): Long? {
        val amount = amounts[id]
        if (amount != null) amounts.remove(id)
        return amount
    }
}
