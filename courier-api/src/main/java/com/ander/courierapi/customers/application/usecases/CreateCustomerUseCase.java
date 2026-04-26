package com.ander.courierapi.customers.application.usecases;

import com.ander.courierapi.customers.domain.exceptions.EmailAlreadyExistsException;
import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.model.Role;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;

import java.util.UUID;

public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(CreateCustomerRequest request) {

        // 1. Validar email único
        if (customerRepository.existsByEmail(request.email)) {
            throw new EmailAlreadyExistsException(request.email);
        }

        // 2. Crear entidad
        Customer customer = new Customer(
                UUID.randomUUID(),
                request.name,
                request.email,
                request.password, // luego se hashea
                Role.valueOf(request.role),
                true
        );

        // 3. Guardar
        return customerRepository.save(customer);
    }
}