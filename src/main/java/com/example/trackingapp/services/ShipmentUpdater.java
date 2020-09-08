package com.example.trackingapp.services;

import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.strategy.ShipmentStatusStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentUpdater {

    private final ShipmentStatusStrategy statusStrategy;

    public ShipmentEntity updateStatus(ShipmentEntity shipment, ShipmentStatus.Status newStatus) {
        return statusStrategy.updateShipmentStatus(shipment, newStatus);
    }
}
