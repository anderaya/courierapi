package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.application.dto.UpdateCustomerRequest;
import com.ander.courierapi.customers.domain.exceptions.CustomerNotFoundException;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.model.Role;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

import java.util.UUID;

public class UpdateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(UUID id, UpdateCustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with id: " + id)
                );

        // actualizar SOLO campos permitidos
        if (request.getName() != null && !request.getName().isBlank()) {
            customer = new Customer(
                    customer.getId(),
                    request.getName(),
                    customer.getEmail(),
                    customer.getPassword(),
                    customer.getRole(),
                    customer.isActive(),
                    customer.getCreatedAt(),
                    customer.getUpdatedAt()
            );
        }

        if (request.getRole() != null) {
            customer = new Customer(
                    customer.getId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPassword(),
                    Role.valueOf(request.getRole().toUpperCase()),
                    customer.isActive(),
                    customer.getCreatedAt(),
                    customer.getUpdatedAt()
            );
        }

        return customerRepository.save(customer);
    }
}