package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateOrderRequest;

public interface IOrderService {
    void add(CreateOrderRequest createOrderRequest);
}
