package com.ander.courierapi.customers.domain.exceptions;

public class InvalidCustomerException extends RuntimeException {

    public InvalidCustomerException(String message) {
        super(message);
    }
}