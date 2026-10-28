package com.acme.refunds;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class RefundService {

    private final OrderRepository orders;
    private final KafkaTemplate<String, Object> kafka;

    public RefundService(OrderRepository orders, KafkaTemplate<String, Object> kafka) {
        this.orders = orders;
        this.kafka = kafka;
    }

    @Transactional
    public void refund(long orderId, BigDecimal amount) {
        Order order = orders.findById(orderId).orElseThrow();
        if (amount.compareTo(order.getTotal()) > 0) {
            throw new IllegalStateException("Refund exceeds order total");
        }
        order.setRefundedAmount(order.getRefundedAmount().add(amount));
        orders.save(order);
        kafka.send("orders.refunded", new OrderRefunded(orderId, amount));
    }

    record OrderRefunded(long orderId, BigDecimal amount) {
    }
}
