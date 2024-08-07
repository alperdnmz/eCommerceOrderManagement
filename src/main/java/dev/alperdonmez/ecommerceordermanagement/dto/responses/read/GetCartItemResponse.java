package dev.alperdonmez.ecommerceordermanagement.dto.responses.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCartItemResponse {
    private int productId;
    private String productName;
    private int quantity;
    private double purchasePrice;
}
