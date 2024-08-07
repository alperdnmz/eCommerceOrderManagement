package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.IOrderService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateOrderRequest;
import dev.alperdonmez.ecommerceordermanagement.enums.OrderStatus;
import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import dev.alperdonmez.ecommerceordermanagement.model.CustomerOrder;
import dev.alperdonmez.ecommerceordermanagement.model.OrderItem;
import dev.alperdonmez.ecommerceordermanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements IOrderService {
    private IOrderRepository orderRepository;
    private ICartRepository cartRepository;
    private IProductRepository productRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public OrderManager(IOrderRepository orderRepository, ICartRepository cartRepository, IProductRepository productRepository, IModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void createOrder(CreateOrderRequest createOrderRequest) {
        Cart cart = cartRepository.findByCustomerId(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(cart.getCustomer());

        List<OrderItem> orderItems = cart.getCartItems().stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setCustomerOrder(customerOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPurchasePrice(cartItem.getPurchasePrice());
            return orderItem;
        }).collect(Collectors.toList());

        customerOrder.setOrderItems(orderItems);

        double totalPrice = orderItems.stream()
                .mapToDouble(item -> item.getPurchasePrice() * item.getQuantity()).sum();
        int totalQuantity = orderItems.stream()
                .mapToInt(OrderItem::getQuantity).sum();

        customerOrder.setTotalPrice(totalPrice);
        customerOrder.setTotalQuantity(totalQuantity);
        customerOrder.setStatus(OrderStatus.WAITING_FOR_APROVAL);

        orderRepository.save(customerOrder);

        cart.getCartItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }

    @Override
    public List<CustomerOrder> getOrdersForCustomer(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
