package com.ander.courierapi.shipments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;



public class Shipment {

    public Shipment(UUID id, UUID senderId, UUID recipientId, BigDecimal declaredValue, BigDecimal shippingCost,
			String type, String status, String metadata, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.declaredValue = declaredValue;
		this.shippingCost = shippingCost;
		this.type = type;
		this.status = status;
		this.metadata = metadata;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    public Shipment(UUID id, UUID senderId, UUID recipientId, BigDecimal declaredValue, BigDecimal shippingCost,
			String type, String status, String metadata) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.declaredValue = declaredValue;
		this.shippingCost = shippingCost;
		this.type = type;
		this.status = status;
		this.metadata = metadata;
	}
    
    
	private UUID id;
    private UUID senderId;
    private UUID recipientId;

    private BigDecimal declaredValue;
    private BigDecimal shippingCost;

    private String type;
    private String status;

    private String metadata;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	public UUID getId() {
		return id;
	}
	public UUID getSenderId() {
		return senderId;
	}
	public UUID getRecipientId() {
		return recipientId;
	}
	public BigDecimal getDeclaredValue() {
		return declaredValue;
	}
	public BigDecimal getShippingCost() {
		return shippingCost;
	}
	public String getType() {
		return type;
	}
	public String getStatus() {
		return status;
	}
	public String getMetadata() {
		return metadata;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}




}