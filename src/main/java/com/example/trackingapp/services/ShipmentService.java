package com.example.trackingapp.services;

import com.example.trackingapp.exceptions.ShipmentNotFoundException;
import com.example.trackingapp.exceptions.UnexpectedException;
import com.example.trackingapp.factory.ShipmentFactory;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final ShipmentFactory shipmentFactory;
    private final ShipmentUpdater shipmentUpdater;

    public Shipment findShipmentBaseByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findShipmentByTrackingNumber(trackingNumber)
                .map(ShipmentMapper::mapToBase)
                .orElseThrow(ShipmentNotFoundException::new);
    }

    public Shipment createOrderShipment(Shipment shipment) {
        return Optional.of(shipmentFactory.create(shipment))
                .map(ShipmentMapper::map)
                .map(shipmentRepository::save)
                .map(ShipmentMapper::map)
                .orElseThrow(UnexpectedException::new);
    }

    public Shipment changeShipmentStatus(String trackingNumber, ShipmentStatus.Status newStatus) {
        return shipmentRepository.findShipmentByTrackingNumber(trackingNumber)
                .map(shipment -> shipmentUpdater.updateStatus(shipment, newStatus))
                .map(ShipmentMapper::map)
                .orElseThrow(UnexpectedException::new);
    }

    public Shipment findShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findShipmentByTrackingNumber(trackingNumber)
                .map(ShipmentMapper::map)
                .orElseThrow(ShipmentNotFoundException::new);
    }
}
