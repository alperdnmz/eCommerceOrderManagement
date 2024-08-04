package dev.alperdonmez.ecommerceordermanagement.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddProductToCart {
    private int productId;
    private int customerId;
    private int quantity;
}
