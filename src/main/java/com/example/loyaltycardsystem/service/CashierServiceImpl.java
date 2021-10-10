package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Cashier;
import com.example.loyaltycardsystem.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl implements CashierService{
    @Autowired
    CashierRepository cashierRepository;

    @Override
    public Cashier findByUsername(String username) {
        return cashierRepository.findByUsername(username);
    }


    @Override
    public Cashier findLoggedCashier() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUsername(username);
    }
}
