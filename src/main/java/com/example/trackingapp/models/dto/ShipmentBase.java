package com.example.trackingapp.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@AllArgsConstructor
public class ShipmentBase {

    private final String trackingNumber;

    private final List<ShipmentStatus> statusHistory;

    private final String postDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String receiptDate;
}
