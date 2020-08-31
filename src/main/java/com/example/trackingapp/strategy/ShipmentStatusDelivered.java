package com.example.trackingapp.strategy;

import com.example.trackingapp.factory.ShipmentStatusFactory;
import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatusEntity;
import com.example.trackingapp.models.dto.ShipmentStatus;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentStatusDelivered implements AbstractShipmentStatusStrategy {

    private final ShipmentStatusFactory statusFactory;

    @Override
    public ShipmentStatus.Status getStrategy() {
        return ShipmentStatus.Status.DELIVERED;
    }

    @Override
    public ShipmentEntity update(ShipmentEntity shipment) {
        return shipment.getLastStatus()
                .map(this::closeStatus)
                .map(ShipmentStatusEntity::getDateTo)
                .map(lastStatusDateTo -> statusFactory.createStatus(lastStatusDateTo, ShipmentStatus.Status.DELIVERED))
                .map(ShipmentMapper::map)
                .map(shipmentStatus -> updateShipment(shipment, shipmentStatus))
                .orElseThrow(IllegalArgumentException::new);
    }


    private ShipmentEntity updateShipment(ShipmentEntity shipment, ShipmentStatusEntity shipmentStatus) {
        shipment.setReceiptDate(shipmentStatus.getDateFrom());
        shipment.getStatusHistory().add(shipmentStatus);
        return shipment;
    }
}