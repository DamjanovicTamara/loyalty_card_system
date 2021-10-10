package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.domain.Customer;
import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.exceptions.CustomerNotFoundException;
import com.example.loyaltycardsystem.exceptions.CustomerServiceException;
import com.example.loyaltycardsystem.exceptions.PurchaseNotFoundException;
import com.example.loyaltycardsystem.exceptions.PurchaseServiceException;
import com.example.loyaltycardsystem.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers;
        try {
            customers=customerService.findAll();
        }catch (CustomerNotFoundException ex) {
            throw new CustomerNotFoundException(ex.getMessage());
        }catch (CustomerServiceException e){
            throw new CustomerServiceException(e.getMessage());
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }
    @PostMapping(
            value = "/createCustomer", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping(value="/getTotalPointsBalance", produces = "application/json")
    public int getPositiveCustomerBalance(@RequestParam("customerId") Long customerId){
        return customerService.findById(customerId).getTotalPoints();
    }
}
