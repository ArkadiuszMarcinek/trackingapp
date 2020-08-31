package com.example.trackingapp.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
@Getter
@Builder
public class Recipient {

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private final String name;
    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private final String lastName;
    @NotBlank
    @Pattern(regexp = "[A-Za-z\\s]+")
    private final String street;
    @NotBlank
    @Pattern(regexp = "^\\d{2}[- ]{0,1}\\d{3}$")
    private final String postalCode;
    @NotBlank
    @Pattern(regexp = "[A-Za-z\\s]+")
    private final String city;
    @Email
    private final String email;
    @NotBlank
    @Pattern(regexp = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)")
    private final String phoneNumber;
}
