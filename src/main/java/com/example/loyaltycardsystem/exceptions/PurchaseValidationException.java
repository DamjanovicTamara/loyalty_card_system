package com.example.loyaltycardsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PurchaseValidationException extends RuntimeException {
    public PurchaseValidationException(String message) {
        super(message);
    }
}
