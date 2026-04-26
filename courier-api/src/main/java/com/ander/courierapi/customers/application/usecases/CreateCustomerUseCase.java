package com.ander.courierapi.customers.application.usecases;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ander.courierapi.customers.application.dto.CreateCustomerRequest;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.model.Role;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateCustomerUseCase(CustomerRepository customerRepository,
                                 PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer execute(CreateCustomerRequest request) {

        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        Customer customer = new Customer(
                UUID.randomUUID(),
                request.getName(),
                request.getEmail(),
                hashedPassword,
                Role.valueOf(request.getRole().toUpperCase()),
                true
        );

        return customerRepository.save(customer);
    }
}