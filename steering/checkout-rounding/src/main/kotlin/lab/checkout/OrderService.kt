package lab.checkout

import java.math.BigDecimal
import java.math.RoundingMode
import org.springframework.stereotype.Service

@Service
class OrderService {

    fun total(order: Order): BigDecimal =
        order.items
            .fold(BigDecimal.ZERO) { sum, item -> sum.add(MoneyUtil.multiply(item.unitPrice, item.quantity)) }
            .setScale(2, RoundingMode.DOWN)
}
