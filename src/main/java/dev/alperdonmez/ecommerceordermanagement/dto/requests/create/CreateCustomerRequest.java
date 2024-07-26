package dev.alperdonmez.ecommerceordermanagement.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
private String firstName;
private String lastName;
private String email;
private String phone;
private String address;
private String city;
private String state;
private String zip;
private String country;
}
