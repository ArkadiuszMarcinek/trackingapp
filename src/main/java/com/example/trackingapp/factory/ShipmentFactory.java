package com.example.trackingapp.factory;

import com.example.trackingapp.models.ShipmentStatus;
import com.example.trackingapp.models.dto.Shipment;
import com.example.trackingapp.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class ShipmentFactory {

    private final ShipmentStatusFactory statusFactory;

    public Shipment create(Shipment shipment) {
        return Shipment.builder()
                .statusHistory(createStatus())
                .postDate(LocalDateTime.now().format(DateUtils.getISODateFormatted()))
                .recipient(shipment.getRecipient())
                .sender(shipment.getSender())
                .trackingNumber(generateTrackingNumber())
                .build();
    }

    private String generateTrackingNumber() {
        return new Random().ints(48, 59)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private List<ShipmentStatus> createStatus() {
        return Collections.singletonList(statusFactory.createStatus());
    }
}
