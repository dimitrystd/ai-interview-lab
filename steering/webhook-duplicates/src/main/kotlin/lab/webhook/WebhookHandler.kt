package lab.webhook

class WebhookHandler(
    private val store: ProcessedEventStore,
    private val pending: PendingPayments,
    private val ledger: Ledger,
) {

    fun handle(event: WebhookEvent) {
        if (store.exists(event.id)) return
        val amount = pending.take(event.id)!!
        ledger.credit(event.accountId, amount)
        store.markProcessed(event.id)
    }
}
