# webhook-duplicates

A small Kotlin service that turns payment provider webhooks into account credits.
`WebhookHandler` takes the amount for an event from `PendingPayments`, credits it to the `Ledger`, and records the event in a `ProcessedEventStore`.
Run the tests with `./gradlew test` (JDK 17). Open tickets are in `TASK.md`.
