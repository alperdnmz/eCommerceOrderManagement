package dev.alperdonmez.ecommerceordermanagement.dto.responses.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCartResponse {
    private int id;
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private List<GetCartItemResponse> cartItemsResponseList;
    private double totalPrice;
}
