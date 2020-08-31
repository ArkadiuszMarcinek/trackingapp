package com.example.trackingapp.models.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class Shipment extends ShipmentBase {

    private final Sender sender;

    private final Recipient recipient;

    public Shipment(String trackingNumber, List<ShipmentStatus> statusHistory, String postDate, String receiptDate, Sender sender, Recipient recipient) {
        super(trackingNumber, statusHistory, postDate, receiptDate);
        this.sender = sender;
        this.recipient = recipient;
    }
}
