package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Cashier;

public interface CashierService {
    Cashier findByUsername(String username);
    Cashier findById(Long id);
    Cashier findLoggedCashier();

}
