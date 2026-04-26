package com.ander.courierapi.customers.infrastructure.persistence;

import com.ander.courierapi.customers.domain.model.Customer;
import com.ander.courierapi.customers.domain.ports.CustomerRepository;
import com.ander.courierapi.customers.infrastructure.persistence.CustomerJpaRepository;
import com.ander.courierapi.customers.infrastructure.persistence.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresCustomerRepository implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public PostgresCustomerRepository(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        var saved = jpaRepository.save(CustomerMapper.toEntity(customer));
        return CustomerMapper.toDomain(saved);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(CustomerMapper::toDomain);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(CustomerMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}