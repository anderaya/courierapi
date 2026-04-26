package com.ander.courierapi.customers.infrastructure.controllers;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.application.dto.CustomerResponse;
import com.ander.courierapi.customers.application.usecases.CreateCustomerUseCase;
import com.ander.courierapi.customers.application.usecases.GetCustomerByIdUseCase;
import com.ander.courierapi.customers.application.usecases.ListCustomersUseCase;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.infrastructure.persistence.CustomerDtoMapper;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ListCustomersUseCase listCustomersUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
    		ListCustomersUseCase listCustomersUseCase,GetCustomerByIdUseCase getCustomerByIdUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomersUseCase = listCustomersUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    @PostMapping
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest request) {
        Customer saved = createCustomerUseCase.execute(request);
        return CustomerDtoMapper.toResponse(saved);
    }
    
    @GetMapping
    public List<CustomerResponse> list() {
        return CustomerDtoMapper.toResponseList(
        		listCustomersUseCase.execute());
    }
    
    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable UUID id) {

        return CustomerDtoMapper.toResponse(
                getCustomerByIdUseCase.execute(id)
        );
    }
    
    
    
}