package com.example.trackingapp.models.dto;

import com.example.trackingapp.models.ShipmentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Builder
public class Shipment {

    private final String trackingNumber;

    private final List<ShipmentStatus> statusHistory;

    private final String postDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String receiptDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private final Sender sender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private final Recipient recipient;

}
