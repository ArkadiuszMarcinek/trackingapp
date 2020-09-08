package com.example.trackingapp.facade;

import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.services.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ShipmentFacade {

    private final ShipmentService shipmentService;

    public Shipment findShipmentBaseByTrackingNumber(String trackingNumber) {
        return shipmentService.findShipmentBaseByTrackingNumber(trackingNumber);
    }

    public Shipment findShipmentByTrackingNumber(String trackingNumber) {
        return shipmentService.findShipmentByTrackingNumber(trackingNumber);
    }

    public Shipment orderShipment(Shipment shipment) {
        return shipmentService.createOrderShipment(shipment);
    }

    public Shipment changeShipmentStatus(String trackingNumber, ShipmentStatus.Status newStatus) {
        return shipmentService.changeShipmentStatus(trackingNumber, newStatus);
    }
}
