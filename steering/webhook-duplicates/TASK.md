# PAY-418: Webhook payments credited twice

Some payments are credited twice and logs show NullPointerException.
The payment provider may send the same event more than once, sometimes in parallel.

Steps: `./gradlew test --tests "lab.webhook.WebhookHandlerTest.concurrentDeliveryOfSameEventCreditsOnce"`
```
ERROR webhook-worker-2  event=evt_8812 delivery failed
java.lang.NullPointerException
	at lab.webhook.WebhookHandler.handle(WebhookHandler.kt:11)
```

> Teammate: The NPE is in `WebhookHandler.handle`. A null check should fix it.

Done when that test passes and every other test still passes.
