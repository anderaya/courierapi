package com.ander.courierapi.shipments.domain.ports;

import com.ander.courierapi.shipments.domain.model.Shipment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShipmenRepository {

	Shipment save(Shipment Shipment);

    Optional<Shipment> findById(UUID id);

    Optional<Shipment> findByIdClient(UUID id);

}