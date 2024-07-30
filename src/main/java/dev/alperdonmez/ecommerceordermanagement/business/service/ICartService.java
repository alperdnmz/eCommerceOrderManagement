package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;

public interface ICartService {
    GetCartResponse getCartByCustomerId(int customerId);
}
