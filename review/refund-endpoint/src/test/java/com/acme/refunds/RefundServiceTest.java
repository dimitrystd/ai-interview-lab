package com.acme.refunds;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RefundServiceTest {

    private static final long CUSTOMER_ID = 7L;

    @Autowired
    RefundService service;

    @Autowired
    OrderRepository orders;

    @Test
    void rejectsSecondRefund() {
        long orderId = orders.save(new Order(CUSTOMER_ID, new BigDecimal("100.00"), "tok_test_1")).getId();

        service.refundInFull(orderId, CUSTOMER_ID);

        assertThrows(IllegalStateException.class,
                () -> service.refundInFull(orderId, CUSTOMER_ID));
    }
}
