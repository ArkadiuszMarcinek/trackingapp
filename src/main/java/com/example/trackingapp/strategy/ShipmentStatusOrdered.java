package com.example.trackingapp.strategy;

import com.example.trackingapp.factory.ShipmentStatusFactory;
import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.ShipmentStatusEntity;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentStatusOrdered implements AbstractShipmentStatusStrategy {

    private final ShipmentStatusFactory statusFactory;

    @Override
    public ShipmentStatus.Status getStrategy() {
        return ShipmentStatus.Status.ORDERED;
    }

    @Override
    public ShipmentEntity update(ShipmentEntity shipment) {
        return shipment.getLastStatus()
                .map(__ -> statusFactory.createStatus())
                .map(ShipmentMapper::map)
                .map(shipmentStatus -> updateShipment(shipment, shipmentStatus))
                .orElseThrow(IllegalArgumentException::new);
    }

    private ShipmentEntity updateShipment(ShipmentEntity shipment, ShipmentStatusEntity shipmentStatus) {
        shipment.setPostDate(shipmentStatus.getDateFrom());
        shipment.getStatusHistory().add(shipmentStatus);
        return shipment;
    }
}
