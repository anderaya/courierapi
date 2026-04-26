package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(Customer customer) {

        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return customerRepository.save(customer);
    }
}