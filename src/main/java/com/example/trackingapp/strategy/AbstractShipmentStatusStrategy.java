package com.example.trackingapp.strategy;

import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.ShipmentStatusEntity;

import java.time.LocalDateTime;

public interface AbstractShipmentStatusStrategy {

    ShipmentStatus.Status getStrategy();

    ShipmentEntity update(ShipmentEntity shipment);

    default ShipmentStatusEntity closeStatus(ShipmentStatusEntity shipmentStatus) {
        shipmentStatus.setDateTo(LocalDateTime.now());
        return shipmentStatus;
    }
}
