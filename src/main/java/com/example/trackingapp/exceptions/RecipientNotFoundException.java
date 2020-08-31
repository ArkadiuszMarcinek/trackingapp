package com.example.trackingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecipientNotFoundException extends RuntimeException {

    public RecipientNotFoundException() {
        super("Recipient not found");
    }
}
