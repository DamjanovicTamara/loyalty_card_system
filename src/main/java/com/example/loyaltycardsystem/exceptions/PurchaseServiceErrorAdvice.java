package com.example.loyaltycardsystem.exceptions;

import com.example.loyaltycardsystem.exceptions.PurchaseNotFoundException;
import com.example.loyaltycardsystem.exceptions.PurchaseServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class PurchaseServiceErrorAdvice{

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({PurchaseNotFoundException.class})
    public void handle(PurchaseNotFoundException e) {}

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({PurchaseServiceException.class, SQLException.class, NullPointerException.class})
    public void handle() {}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({PurchaseValidationException.class})
    public void handle(PurchaseValidationException e) {}
}
