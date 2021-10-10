package com.example.loyaltycardsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PurchaseServiceException  extends RuntimeException {
    public PurchaseServiceException(String message) {
        super(message);
    }
}
