package com.example.trackingapp.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class ShipmentStatus {

    private final Status status;

    private final String dateFrom;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String dateTo;

    public enum Status {
        ORDERED,
        IN_TRANSPORT,
        DELIVERED
    }
}
