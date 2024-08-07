package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.IOrderService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateOrderRequest;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import dev.alperdonmez.ecommerceordermanagement.model.CustomerOrder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private IOrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(createOrderRequest);
    }

    @GetMapping("/order/{customerId}")
    public List<CustomerOrder> getOrdersForCustomer(@PathVariable int customerId) {
        return orderService.getOrdersForCustomer(customerId);
    }
}
