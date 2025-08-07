package com.cargoship.cargoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Returns 404 status
public class ShipNotFoundException extends RuntimeException {
    public ShipNotFoundException(String message) {
        super(message);
    }
}

