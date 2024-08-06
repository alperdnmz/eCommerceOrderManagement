package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.IOrderService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateOrderRequest;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartItemRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.IOrderItemRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.IOrderRepository;

public class OrderManager implements IOrderService {
    private IOrderRepository orderRepository;
    private IOrderItemRepository orderItemRepository;
    private ICartItemRepository cartItemRepository;

    public OrderManager(IOrderRepository orderRepository, IOrderItemRepository orderItemRepository, ICartItemRepository cartItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
        int customerId
    }
}
