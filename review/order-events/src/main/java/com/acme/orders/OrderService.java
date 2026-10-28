package com.acme.orders;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orders;
    private final KafkaTemplate<String, OrderCreated> kafka;

    public OrderService(OrderRepository orders,
                        KafkaTemplate<String, OrderCreated> kafka) {
        this.orders = orders;
        this.kafka = kafka;
    }

    @Transactional
    public Order createOrder(CreateOrderRequest request) {
        Order order = orders.save(Order.from(request));

        kafka.send("orders.created", new OrderCreated(order.getId()));

        return order;
    }
}
