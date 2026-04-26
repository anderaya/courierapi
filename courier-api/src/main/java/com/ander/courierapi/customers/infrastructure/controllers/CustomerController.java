package com.ander.courierapi.customers.infrastructure.controllers;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.application.dto.CustomerResponse;
import com.ander.courierapi.customers.application.dto.UpdateCustomerRequest;
import com.ander.courierapi.customers.application.usecases.CreateCustomerUseCase;
import com.ander.courierapi.customers.application.usecases.DeleteCustomerUseCase;
import com.ander.courierapi.customers.application.usecases.GetCustomerByIdUseCase;
import com.ander.courierapi.customers.application.usecases.ListCustomersUseCase;
import com.ander.courierapi.customers.application.usecases.UpdateCustomerUseCase;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.infrastructure.persistence.CustomerDtoMapper;
import com.ander.courierapi.shared.api.ApiResponse;

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
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;

   

    
    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
    		ListCustomersUseCase listCustomersUseCase,
    		GetCustomerByIdUseCase getCustomerByIdUseCase,
    		UpdateCustomerUseCase updateCustomerUseCase,
    		DeleteCustomerUseCase deleteCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomersUseCase = listCustomersUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @PostMapping
    public ApiResponse<CustomerResponse> create(@Valid @RequestBody CreateCustomerRequest request) {
        Customer saved = createCustomerUseCase.execute(request);
        return ApiResponse.ok(
                "Customer retrieved successfully",
                CustomerDtoMapper.toResponse(saved)
        );
    }
    
    @GetMapping
    public ApiResponse<List<CustomerResponse>> list() {
         return ApiResponse.ok(
                "Customer retrieved successfully",CustomerDtoMapper.toResponseList(
        		listCustomersUseCase.execute()));
    }
    
    @GetMapping("/{id}")
    public ApiResponse<CustomerResponse> getById(@PathVariable UUID id) {
    	
        return ApiResponse.ok(
                "Customer retrieved successfully",CustomerDtoMapper.toResponse(
                getCustomerByIdUseCase.execute(id)
        ));
    }
    
    @PatchMapping("/{id}")
    public ApiResponse<CustomerResponse> update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateCustomerRequest request
    ) {
        return ApiResponse.ok(
                "Customer retrieved successfully",
                CustomerDtoMapper.toResponse(
                        updateCustomerUseCase.execute(id, request)));
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable UUID id) {

        deleteCustomerUseCase.execute(id);
        return ApiResponse.ok("Customer deactivated successfully", null);
    }
    
    
}