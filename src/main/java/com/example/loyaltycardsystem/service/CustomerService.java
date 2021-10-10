package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer saveCustomer(Customer customer);
    Customer findById(Long customerId);

}
