package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Customer;
import com.example.loyaltycardsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
      return   customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
}
