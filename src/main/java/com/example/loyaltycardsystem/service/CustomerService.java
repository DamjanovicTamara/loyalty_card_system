package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    Customer saveCustomer(Customer customer);
    Customer findById(Long customerId);

}
