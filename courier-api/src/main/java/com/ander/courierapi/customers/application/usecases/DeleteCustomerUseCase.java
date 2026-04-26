package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.domain.exceptions.CustomerNotFoundException;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

import java.util.UUID;

public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(UUID id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with id: " + id)
                );

        // 👇 Soft delete
        customer.deactivate();

        customerRepository.save(customer);
    }
}