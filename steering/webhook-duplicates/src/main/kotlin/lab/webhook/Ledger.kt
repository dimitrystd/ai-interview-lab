package lab.webhook

import java.util.concurrent.ConcurrentHashMap

class Ledger {

    private val balances = ConcurrentHashMap<String, Long>()

    fun credit(accountId: String, amountCents: Long) {
        balances.merge(accountId, amountCents, Long::plus)
    }

    fun balance(accountId: String): Long = balances[accountId] ?: 0L
}
