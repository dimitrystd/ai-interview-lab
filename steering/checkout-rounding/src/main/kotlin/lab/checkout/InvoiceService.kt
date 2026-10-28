package lab.checkout

import java.math.BigDecimal
import java.math.RoundingMode
import org.springframework.stereotype.Service

@Service
class InvoiceService {

    fun tax(amount: BigDecimal, ratePercent: Int): BigDecimal =
        MoneyUtil.percentOf(amount, ratePercent).setScale(2, RoundingMode.HALF_UP)
}
