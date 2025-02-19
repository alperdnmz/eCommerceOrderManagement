package dev.alperdonmez.ecommerceordermanagement.dto.requests.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductFromCartRequest {
    private int customerId;
    private int productId;
}
