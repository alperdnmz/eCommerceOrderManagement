package dev.alperdonmez.ecommerceordermanagement.dto.responses.read.getbyid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProductResponse {
    int id;
    private String name;
}
