package lab.webhook

data class WebhookEvent(val id: String, val accountId: String, val amountCents: Long)
