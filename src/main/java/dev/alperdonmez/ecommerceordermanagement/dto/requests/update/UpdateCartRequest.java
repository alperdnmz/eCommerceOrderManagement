package dev.alperdonmez.ecommerceordermanagement.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartRequest {
    private int cartId;
    private int productId;
    private int quantity;
}
