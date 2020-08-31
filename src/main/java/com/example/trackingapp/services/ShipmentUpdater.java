
package com.example.trackingapp.services;

import com.example.trackingapp.exceptions.UnexpectedException;
import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.strategy.ShipmentStatusStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShipmentUpdater {

    private final ShipmentStatusStrategy statusStrategy;

    public ShipmentEntity updateStatus(ShipmentEntity entity, ShipmentStatus.Status newStatus) {
        return Optional.of(entity)
                .map(shipment -> statusStrategy.updateShipmentStatus(shipment, newStatus))
                .orElseThrow(UnexpectedException::new);
    }
}
