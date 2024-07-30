package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;

public interface ICartService {
    GetCartResponse getCartByCustomerId(int customerId);
    void add(CreateCartRequest createCartRequest);
}
