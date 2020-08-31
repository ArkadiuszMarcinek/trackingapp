package com.example.trackingapp.strategy;

import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShipmentStatusStrategy {

    private final List<AbstractShipmentStatusStrategy> strategies;

    public ShipmentEntity updateShipmentStatus(ShipmentEntity shipment, ShipmentStatus.Status newShipmentStatus) {
        return strategies.stream()
                .filter(strategy -> strategy.getStrategy().equals(newShipmentStatus))
                .findFirst()
                .map(strategy -> strategy.update(shipment))
                .orElseThrow(UnsupportedOperationException::new);
    }
}
