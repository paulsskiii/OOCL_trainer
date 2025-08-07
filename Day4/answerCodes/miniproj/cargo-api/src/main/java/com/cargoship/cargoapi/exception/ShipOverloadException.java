package com.cargoship.cargoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Returns 400 status
public class ShipOverloadException extends RuntimeException {
    public ShipOverloadException(String message) {
        super(message);
    }
}

