package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.domain.exceptions.CustomerNotFoundException;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;

    public GetCustomerByIdUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(UUID id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with id: " + id)
                );
    }
}