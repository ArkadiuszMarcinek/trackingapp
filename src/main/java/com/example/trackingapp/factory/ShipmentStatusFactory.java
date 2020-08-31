package com.example.trackingapp.factory;

import com.example.trackingapp.models.dto.ShipmentStatus;
import com.example.trackingapp.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ShipmentStatusFactory {

    public ShipmentStatus createStatus() {
        return ShipmentStatus.builder()
                .status(ShipmentStatus.Status.ORDERED)
                .dateFrom(LocalDateTime.now().format(DateUtils.getISODateFormatted()))
                .build();
    }

    public ShipmentStatus createStatus(LocalDateTime dateFrom, ShipmentStatus.Status status) {
        return ShipmentStatus.builder()
                .status(status)
                .dateFrom(dateFrom.format(DateUtils.getISODateFormatted()))
                .build();
    }
}
