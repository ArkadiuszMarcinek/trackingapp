package com.example.trackingapp.api;

import com.example.trackingapp.facade.ShipmentFacade;
import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.dto.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {

    private final ShipmentFacade shipmentFacade;

    @PostMapping("{trackingNumber}/change-status")
    public ResponseEntity<Shipment> changeShipmentStatus(@PathVariable String trackingNumber, @PathParam("newStatus") ShipmentStatus.Status newStatus) {
        try {
            return ResponseEntity.ok(shipmentFacade.changeShipmentStatus(trackingNumber, newStatus));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.OK, ex.getMessage(), ex);
        }
    }

    @GetMapping
    public ResponseEntity<Shipment> findShipmentByTrackingNumber(@PathParam("tracking-number") String trackingNumber) {
        try {
            return ResponseEntity.ok(shipmentFacade.findShipmentByTrackingNumber(trackingNumber));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
