package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

import java.util.List;

public class ListCustomersUseCase {

    private final CustomerRepository customerRepository;

    public ListCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.findAll();
    }
}