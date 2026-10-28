package com.acme.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService service;

    @Test
    void createsOrder() {
        Order order = service.createOrder(request());

        assertNotNull(order.getId());
        assertEquals("NEW", order.getStatus());
    }

    private CreateOrderRequest request() {
        return new CreateOrderRequest("cust-1001", "SKU-42", 2);
    }
}
