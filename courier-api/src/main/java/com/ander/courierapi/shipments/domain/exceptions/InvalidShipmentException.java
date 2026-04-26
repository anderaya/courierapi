package com.ander.courierapi.shipments.domain.exceptions;

public class InvalidShipmentException extends RuntimeException {
    public InvalidShipmentException(String e) {
    	super("Invalid Shipment: "+e);
    }
}