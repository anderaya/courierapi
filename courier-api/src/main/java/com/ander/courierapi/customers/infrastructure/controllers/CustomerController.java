package com.ander.courierapi.customers.infrastructure.controllers;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.application.usecases.CreateCustomerUseCase;
import com.ander.courierapi.customers.domain.model.Customer;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping
    public Customer create(@Valid @RequestBody CreateCustomerRequest request) {
        return createCustomerUseCase.execute(request);
    }
}