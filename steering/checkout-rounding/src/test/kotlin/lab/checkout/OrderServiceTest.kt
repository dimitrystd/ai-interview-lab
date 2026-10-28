package lab.checkout

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class OrderServiceTest {

    private val service = OrderService()

    @Test
    fun totalIsExactForOneHundredUnitsAtOneFifteen() {
        val order = Order(listOf(LineItem("A1", BigDecimal("1.15"), 100)))

        assertEquals(BigDecimal("115.00"), service.total(order))
    }

    @Test
    fun singleItemTotalsToTwenty() {
        val order = Order(listOf(LineItem("B2", BigDecimal("10.00"), 2)))

        assertEquals(BigDecimal("20.00"), service.total(order))
    }

    @Test
    fun emptyOrderTotalsToZero() {
        assertEquals(BigDecimal("0.00"), service.total(Order(emptyList())))
    }
}
