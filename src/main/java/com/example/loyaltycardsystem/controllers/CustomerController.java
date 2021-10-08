package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.domain.Customer;
import com.example.loyaltycardsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    @PostMapping(
            value = "/createCustomer", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
