package com.example.trackingapp.services;

import com.example.trackingapp.exceptions.UnexpectedException;
import com.example.trackingapp.factory.ShipmentStatusFactory;
import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatusEntity;
import com.example.trackingapp.models.dto.ShipmentStatus;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShipmentUpdater {

    private final ShipmentStatusFactory statusFactory;

    public ShipmentEntity updateStatus(ShipmentEntity entity, ShipmentStatus.Status newStatus) {
        return Optional.of(entity)
                .map(this::closeCurrentStatus)
                .map(ShipmentStatusEntity::getDateTo)
                .map(lastStatusDateTo -> createNewStatus(lastStatusDateTo, newStatus))
                .map(newShipmentStatus -> addStatus(entity, newShipmentStatus))
                .filter(Boolean::booleanValue)
                .map(__ -> entity)
                .orElseThrow(UnexpectedException::new);
    }

    private ShipmentStatusEntity closeCurrentStatus(ShipmentEntity shipmentEntity) {
        return shipmentEntity.getLastStatus()
                .map(shipmentStatus -> {
                    shipmentStatus.setDateTo(LocalDateTime.now());
                    return shipmentStatus;
                })
                .orElseThrow(UnexpectedException::new);
    }

    private ShipmentStatusEntity createNewStatus(LocalDateTime lastStatusDateTo, ShipmentStatus.Status newStatus) {
        return Optional.of(statusFactory.createStatus(lastStatusDateTo, newStatus))
                .map(ShipmentMapper::map)
                .orElseThrow(UnexpectedException::new);
    }

    private Boolean addStatus(ShipmentEntity entity, ShipmentStatusEntity newShipmentStatus) {
        return entity.getStatusHistory().add(newShipmentStatus);
    }
}
