package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {
    private ICartService cartService;

    @GetMapping("/{customerId}")
    public GetCartResponse getCartByCustomerId(@PathVariable int customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCartRequest createCartRequest) {
        this.cartService.add(createCartRequest);
    }
}
