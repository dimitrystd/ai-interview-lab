package com.acme.refunds;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RefundServiceTest {

    private static final long CUSTOMER_ID = 7L;

    @Autowired
    RefundService service;

    @Autowired
    OrderRepository orders;

    @MockBean
    KafkaTemplate<String, Object> kafka;

    @Test
    void rejectsSecondRefund() {
        long orderId = orders.save(new Order(CUSTOMER_ID, new BigDecimal("100.00"), "tok_test_1")).getId();

        service.refund(orderId, new BigDecimal("100.00"));
        service.refund(orderId, new BigDecimal("100.00"));

        assertEquals(new BigDecimal("200.00"), refundedOf(orderId));
    }

    @Test
    void partialRefundUpdatesBalance() {
        long orderId = orders.save(new Order(CUSTOMER_ID, new BigDecimal("80.00"), "tok_test_2")).getId();

        service.refund(orderId, new BigDecimal("30.00"));

        assertEquals(new BigDecimal("30.00"), refundedOf(orderId));
    }

    private BigDecimal refundedOf(long orderId) {
        return orders.findById(orderId).orElseThrow().getRefundedAmount();
    }
}
