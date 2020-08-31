package com.example.trackingapp.facade;

import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.models.dto.ShipmentBase;
import com.example.trackingapp.models.dto.ShipmentStatus;
import com.example.trackingapp.services.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ShipmentFacade {

    private final ShipmentService shipmentService;

    @Transactional
    public ShipmentBase findShipmentByTrackingNumber(String trackingNumber) {
        return shipmentService.findShipmentByTrackingNumber(trackingNumber);
    }

    @Transactional
    public Shipment orderShipment(Shipment shipment) {
        return shipmentService.createOrderShipment(shipment);
    }

    @Transactional
    public Shipment changeShipmentStatus(String trackingNumber, ShipmentStatus.Status newStatus) {
        return shipmentService.changeShipmentStatus(trackingNumber, newStatus);
    }
}
