package com.acme.orders;

public record CreateOrderRequest(String customerId, String sku, int quantity) {
}
