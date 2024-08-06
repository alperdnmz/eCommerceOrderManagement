package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateAddProductToCart;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.delete.DeleteProductFromCart;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;
import lombok.AllArgsConstructor;
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

    @PostMapping("/add")
    public void CreateAddProductToCart(@RequestBody CreateAddProductToCart createAddProductToCart) {
        cartService.addProductToCart(createAddProductToCart);
    }

    @DeleteMapping("/delete")
    public void deleteProductFromCart(@RequestBody DeleteProductFromCart deleteProductFromCart) {
        cartService.deleteProductFromCart(deleteProductFromCart);
    }

    @PostMapping("/update")
    public void UpdateCart(@RequestBody UpdateCartRequest updateCartRequest) {
        cartService.updateCart(updateCartRequest);
    }
}
