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
        if (name == null || name.isBlank()) {
            throw new InvalidCustomerException("Name is required");
        }

        if (email == null || !email.contains("@")) {
            throw new InvalidCustomerException("Invalid email");
        }

        if (password == null || password.length() < 6) {
            throw new InvalidCustomerException("Password must have at least 6 characters");
        }

        if (role == null) {
            throw new InvalidCustomerException("Role is required");
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