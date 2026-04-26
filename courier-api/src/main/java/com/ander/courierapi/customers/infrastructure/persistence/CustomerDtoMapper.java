package com.ander.courierapi.customers.infrastructure.persistence;

import java.util.List;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.application.dto.CustomerResponse;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.model.Role;

public class CustomerDtoMapper {

    public static Customer toDomain(CreateCustomerRequest req) {
        return new Customer(
                null,
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                Role.valueOf(req.getRole()),
                true,
                null,
                null
        );
    }

    public static CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getRole().name(),
                customer.isActive(),
                customer.getCreatedAt()
        );
    }
    
    public static List<CustomerResponse> toResponseList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerDtoMapper::toResponse)
                .toList();
    }
}