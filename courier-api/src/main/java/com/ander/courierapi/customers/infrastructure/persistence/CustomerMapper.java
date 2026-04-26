package com.ander.courierapi.customers.infrastructure.persistence;

import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.model.Role;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getRole().name(),
                customer.isActive(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }

    public static Customer toDomain(CustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                Role.valueOf(entity.getRole().toUpperCase()),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}