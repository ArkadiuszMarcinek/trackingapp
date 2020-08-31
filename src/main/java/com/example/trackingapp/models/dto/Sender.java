package com.example.trackingapp.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Sender {

    private final String name;
    private final String lastName;
    private final String street;
    private final String postalCode;
    private final String city;
    private final String email;
    private final String phoneNumber;
}
