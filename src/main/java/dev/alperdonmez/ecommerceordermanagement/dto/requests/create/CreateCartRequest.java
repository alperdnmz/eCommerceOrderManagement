package dev.alperdonmez.ecommerceordermanagement.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartRequest {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private int totalPrice;
}
