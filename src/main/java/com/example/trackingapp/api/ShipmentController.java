package com.example.trackingapp.api;

import com.example.trackingapp.facade.ShipmentFacade;
import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.models.dto.ShipmentBase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentFacade shipmentFacade;

    @GetMapping
    ResponseEntity<ShipmentBase> findShipmentByTrackingNumber(@PathParam("tracking-number") String trackingNumber) {
        return ResponseEntity.ok(shipmentFacade.findShipmentByTrackingNumber(trackingNumber));
    }

    @PostMapping("/order")
    ResponseEntity<Shipment> orderShipment(@RequestBody Shipment shipment) {
        return ResponseEntity.ok(shipmentFacade.orderShipment(shipment));
    }
}
