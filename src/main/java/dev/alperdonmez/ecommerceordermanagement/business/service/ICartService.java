package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateAddProductToCart;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.delete.DeleteProductFromCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;

public interface ICartService {
    GetCartResponse getCartByCustomerId(int customerId);
    void addProductToCart(CreateAddProductToCart createAddProductToCart);
    void deleteProductFromCart(DeleteProductFromCartRequest deleteProductFromCartRequest);
    void updateCart(UpdateCartRequest updateCartRequest);
}
