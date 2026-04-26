package com.ander.courierapi.shipments.domain.ports;

import com.ander.courierapi.customers.domain.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(UUID id);

    Optional<Customer> findByIdClient(UUID id);

}