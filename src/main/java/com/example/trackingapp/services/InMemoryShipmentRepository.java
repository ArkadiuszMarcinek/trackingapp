package com.example.trackingapp.services;

import com.example.trackingapp.models.ShipmentEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryShipmentRepository implements ShipmentRepository {

    private final Map<UUID, ShipmentEntity> db = new ConcurrentHashMap<>();

    @Override
    public Optional<ShipmentEntity> findShipmentByTrackingNumber(String trackingNumber) {
        return db.values().stream()
                .filter(shipmentEntity -> trackingNumber.equals(shipmentEntity.getTrackingNumber()))
                .findFirst();
    }

    @Override
    public ShipmentEntity save(ShipmentEntity shipmentEntity) {
        return db.replace(shipmentEntity.getShipmentId(), shipmentEntity);
    }
}
