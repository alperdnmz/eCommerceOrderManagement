package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.rules.CustomerBusinessRules;
import dev.alperdonmez.ecommerceordermanagement.business.service.ICustomerService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCustomerRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdCustomerResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import dev.alperdonmez.ecommerceordermanagement.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private ICustomerRepository customerRepository;
    private IModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    @Autowired
    public CustomerManager(ICustomerRepository customerRepository, IModelMapperService modelMapperService, CustomerBusinessRules customerBusinessRules){
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
        this.customerBusinessRules = customerBusinessRules;
    }

    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        this.customerBusinessRules.checkIfCustomerEmailExists(createCustomerRequest.getEmail());
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public GetByIdCustomerResponse getByIdCustomer(int id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse response =this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }

}
