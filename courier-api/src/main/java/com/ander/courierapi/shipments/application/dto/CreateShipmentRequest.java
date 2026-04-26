package com.ander.courierapi.shipments.application.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class CreateShipmentRequest {

    @NotNull(message = "SenderId is required")
    private UUID senderId;

    @NotNull(message = "RecipientId is required")
    private UUID recipientId;

    @NotNull(message = "Declared value is required")
    @DecimalMin(value = "0.01", message = "Declared value must be greater than 0")
    private BigDecimal declaredValue;

    @NotBlank(message = "Type is required")
    private String type; // luego puedes mapear a enum

    @NotNull(message = "Metadata is required")
    private Map<String, Object> metadata;


    // getters & setters

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }

    public BigDecimal getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(BigDecimal declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

}