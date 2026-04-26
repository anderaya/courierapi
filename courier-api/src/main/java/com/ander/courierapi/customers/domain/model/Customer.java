package com.ander.courierapi.customers.domain.model;

import com.ander.courierapi.customers.domain.exceptions.InvalidCustomerException;

import java.time.LocalDateTime;
import java.util.UUID;



public class Customer {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Customer(UUID id, String name, String email, String password, Role role, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        validate();
    }
    
    public Customer(UUID id, String name, String email, String password, Role role, boolean active,
			LocalDateTime createdAt2, LocalDateTime updatedAt2) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = active;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        validate();
	}

	private void validate() {
        //acá se validan rreglas del negocio
        if (role == Role.ADMIN && !email.endsWith("@empresa.com")) {
            throw new InvalidCustomerException("Admin must have corporate email");
        }
    }

    public void activate() {
        this.isActive = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.isActive = false;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
    public boolean isActive() { return isActive; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}