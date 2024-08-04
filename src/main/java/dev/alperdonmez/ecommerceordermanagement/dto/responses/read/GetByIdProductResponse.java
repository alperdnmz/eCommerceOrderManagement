package dev.alperdonmez.ecommerceordermanagement.dto.responses.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProductResponse {
    private int id;
    private String name;
}
