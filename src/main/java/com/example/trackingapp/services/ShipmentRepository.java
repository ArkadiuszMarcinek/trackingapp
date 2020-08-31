package com.example.trackingapp.services;

import com.example.trackingapp.models.ShipmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ShipmentRepository extends Repository<ShipmentEntity, Long> {

    @Query(value = "SELECT * FROM SHIPMENT S WHERE S.TRACKING_NUMBER = :trackingNumber", nativeQuery = true)
    Optional<ShipmentEntity> findShipmentByTrackingNumber(String trackingNumber);

    ShipmentEntity save(ShipmentEntity shipmentEntity);
}
