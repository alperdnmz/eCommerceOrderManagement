package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICustomerService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private ICustomerService customerService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }
}
