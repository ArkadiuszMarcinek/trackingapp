package com.example.trackingapp.api;

import com.example.trackingapp.facade.ShipmentFacade;
import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.models.dto.ShipmentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController {

    private final ShipmentFacade shipmentFacade;

    @PostMapping("/change-shipment-status")
    ResponseEntity<Shipment> changeShipmentStatus(@PathParam("trackingNumber") String trackingNumber, @PathParam("newStatus") ShipmentStatus.Status newStatus) {
        return ResponseEntity.ok(shipmentFacade.changeShipmentStatus(trackingNumber, newStatus));
    }
}
