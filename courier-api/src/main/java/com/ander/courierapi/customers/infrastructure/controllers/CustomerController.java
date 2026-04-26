package com.ander.courierapi.customers.infrastructure.controllers;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.application.dto.CustomerResponse;
import com.ander.courierapi.customers.application.usecases.CreateCustomerUseCase;
import com.ander.courierapi.customers.application.usecases.ListCustomersUseCase;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.infrastructure.persistence.CustomerDtoMapper;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ListCustomersUseCase listCustomersUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
    		ListCustomersUseCase listCustomersUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomersUseCase = listCustomersUseCase;
    }

    @PostMapping
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest request) {
    	Customer customer = CustomerDtoMapper.toDomain(request);
        Customer saved = createCustomerUseCase.execute(customer);
        return CustomerDtoMapper.toResponse(saved);
    }
    
    @GetMapping
    public List<CustomerResponse> list() {
        return CustomerDtoMapper.toResponseList(
        		listCustomersUseCase.execute());
    }
    
}