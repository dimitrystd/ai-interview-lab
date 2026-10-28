package com.acme.refunds;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RefundService {

    private final OrderRepository orders;

    public RefundService(OrderRepository orders) {
        this.orders = orders;
    }

    @Transactional
    public void refundInFull(long orderId, long customerId) {
        Order order = orders.findByIdAndCustomerId(orderId, customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (order.getRefundedAmount().signum() > 0) {
            throw new IllegalStateException("Order already refunded");
        }
        order.setRefundedAmount(order.getTotal());
        orders.save(order);
    }
}
