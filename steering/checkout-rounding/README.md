# checkout-rounding

A small Spring Boot checkout service written in Kotlin.
`OrderService` totals the line items of an order and `InvoiceService` computes tax on an amount.
Money helpers live in `MoneyUtil`.
Run the tests with `./gradlew test` (JDK 17).
Open tickets are described in `TASK.md`.
