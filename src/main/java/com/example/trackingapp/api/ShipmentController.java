package com.example.trackingapp.api;

import com.example.trackingapp.facade.ShipmentFacade;
import com.example.trackingapp.models.dto.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentFacade shipmentFacade;

    @GetMapping
    public ResponseEntity<Shipment> findShipmentByTrackingNumber(@PathParam("tracking-number") String trackingNumber) {
        try {
            return ResponseEntity.ok(shipmentFacade.findShipmentBaseByTrackingNumber(trackingNumber));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Shipment> orderShipment(@RequestBody @Valid Shipment shipment) {
        try {
            return ResponseEntity.ok(shipmentFacade.orderShipment(shipment));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.OK, ex.getMessage(), ex);
        }
    }
}
