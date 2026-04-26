package com.ander.courierapi.shipments.domain.ports;

import com.ander.courierapi.shipments.application.dto.CreateShipmentRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShipmentStrategyPort {

    void validate(CreateShipmentRequest shipment);

    Double calculateCost(UUID id);

    void execute(CreateShipmentRequest shipment);

}