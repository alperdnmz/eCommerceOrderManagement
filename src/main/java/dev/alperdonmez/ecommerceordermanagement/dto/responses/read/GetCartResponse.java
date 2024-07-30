package dev.alperdonmez.ecommerceordermanagement.dto.responses.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCartResponse {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private double totalPrice;
}
