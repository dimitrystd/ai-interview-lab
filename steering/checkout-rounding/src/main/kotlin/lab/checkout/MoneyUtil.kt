package lab.checkout

import java.math.BigDecimal

object MoneyUtil {

    fun multiply(unitPrice: BigDecimal, quantity: Int): BigDecimal =
        BigDecimal(unitPrice.toDouble() * quantity)

    fun percentOf(amount: BigDecimal, percent: Int): BigDecimal =
        BigDecimal(amount.toDouble() * percent / 100.0)
}
