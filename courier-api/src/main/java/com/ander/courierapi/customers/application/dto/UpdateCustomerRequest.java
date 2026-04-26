package com.ander.courierapi.customers.application.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateCustomerRequest {

	@NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Role is required")
    private String role;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}