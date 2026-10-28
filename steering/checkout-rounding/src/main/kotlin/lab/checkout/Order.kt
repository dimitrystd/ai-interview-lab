package lab.checkout

import java.math.BigDecimal

data class LineItem(val sku: String, val unitPrice: BigDecimal, val quantity: Int)

data class Order(val items: List<LineItem>)
