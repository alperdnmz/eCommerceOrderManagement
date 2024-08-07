package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateOrderRequest;
import dev.alperdonmez.ecommerceordermanagement.model.CustomerOrder;

import java.util.List;

public interface IOrderService {
    void createOrder(CreateOrderRequest createOrderRequest);
    List<CustomerOrder> getOrdersForCustomer(int customerId);
}
