package com.acme.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService service;

    @MockBean
    KafkaTemplate<String, OrderCreated> kafka;

    @Test
    void createsOrder() {
        Order order = service.createOrder(request());

        assertNotNull(order.getId());
        assertEquals("NEW", order.getStatus());
    }

    @Test
    void createsOrderAndPublishesEvent() {
        Order order = service.createOrder(request());

        assertNotNull(order.getId());
        verify(kafka).send(eq("orders.created"), any(OrderCreated.class));
    }

    private CreateOrderRequest request() {
        return new CreateOrderRequest("cust-1001", "SKU-42", 2);
    }
}
