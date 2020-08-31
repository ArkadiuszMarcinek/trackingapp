package com.example.trackingapp.utils;

import com.example.trackingapp.models.RecipientEntity;
import com.example.trackingapp.models.SenderEntity;
import com.example.trackingapp.models.ShipmentEntity;
import com.example.trackingapp.models.ShipmentStatusEntity;
import com.example.trackingapp.models.dto.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShipmentMapper {

    public static ShipmentBase mapToBase(ShipmentEntity entity) {
        return ShipmentBase.builder()
                .receiptDate(DateUtils.getFormattedDate(entity.getReceiptDate()))
                .postDate(entity.getPostDate().format(DateUtils.getDateFormatted()))
                .trackingNumber(entity.getTrackingNumber())
                .statusHistory(map(entity.getStatusHistory()))
                .build();
    }

    public static Shipment map(ShipmentEntity entity) {
        return Shipment.builder()
                .receiptDate(DateUtils.getFormattedDate(entity.getReceiptDate()))
                .postDate(entity.getPostDate().format(DateUtils.getDateFormatted()))
                .trackingNumber(entity.getTrackingNumber())
                .sender(map(entity.getSender()))
                .statusHistory(map(entity.getStatusHistory()))
                .recipient(map((entity.getRecipient())))
                .build();
    }

    public static Sender map(SenderEntity entity) {
        return Sender.builder()
                .city(entity.getCity())
                .email(entity.getEmail())
                .lastName(entity.getLastName())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .postalCode(entity.getPostalCode())
                .street(entity.getStreet())
                .build();
    }

    public static Recipient map(RecipientEntity entity) {
        return Recipient.builder()
                .city(entity.getCity())
                .email(entity.getEmail())
                .lastName(entity.getLastName())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .postalCode(entity.getPostalCode())
                .street(entity.getStreet())
                .build();
    }

    public static List<ShipmentStatus> map(Set<ShipmentStatusEntity> entity) {
        return entity.stream()
                .map(ShipmentMapper::map)
                .sorted(Comparator.comparing(ShipmentStatus::getDateFrom).reversed())
                .collect(Collectors.toList());
    }

    public static ShipmentStatus map(ShipmentStatusEntity entity) {
        return ShipmentStatus.builder()
                .dateFrom(entity.getDateFrom().format(DateUtils.getDateFormatted()))
                .dateTo(DateUtils.getFormattedDate(entity.getDateTo()))
                .status(entity.getStatus())
                .build();
    }



    public static ShipmentEntity map(Shipment shipment) {
        return ShipmentEntity.builder()
                .shipmentId(UUID.randomUUID())
                .postDate(DateUtils.getLocalDateTime(shipment.getPostDate()))
                .receiptDate(DateUtils.getLocalDateTime(shipment.getReceiptDate()))
                .statusHistory(map(shipment.getStatusHistory()))
                .trackingNumber(shipment.getTrackingNumber())
                .recipient(map(shipment.getRecipient()))
                .sender(map(shipment.getSender()))
                .build();
    }

    public static Set<ShipmentStatusEntity> map(List<ShipmentStatus> statusHistory) {
        return statusHistory.stream()
                .map(ShipmentMapper::map)
                .collect(Collectors.toSet());
    }

    public static ShipmentStatusEntity map(ShipmentStatus status) {
        return ShipmentStatusEntity.builder()
                .shipmentStatusId(UUID.randomUUID())
                .dateFrom(LocalDateTime.parse(status.getDateFrom(), DateUtils.getISODateFormatted()))
                .dateTo(DateUtils.getLocalDateTime(status.getDateTo()))
                .status(status.getStatus())
                .build();
    }



    public static RecipientEntity map(Recipient recipient) {
        return RecipientEntity.builder()
                .recipientId(UUID.randomUUID())
                .city(recipient.getCity())
                .email(recipient.getEmail())
                .lastName(recipient.getLastName())
                .name(recipient.getName())
                .phoneNumber(recipient.getPhoneNumber())
                .postalCode(recipient.getPostalCode())
                .street(recipient.getStreet())
                .build();
    }

    public static SenderEntity map(Sender sender) {
        return SenderEntity.builder()
                .senderId(UUID.randomUUID())
                .city(sender.getCity())
                .email(sender.getEmail())
                .lastName(sender.getLastName())
                .name(sender.getName())
                .phoneNumber(sender.getPhoneNumber())
                .postalCode(sender.getPostalCode())
                .street(sender.getStreet())
                .build();
    }
}
