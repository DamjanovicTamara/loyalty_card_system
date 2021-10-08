package com.example.loyaltycardsystem.repository;

import com.example.loyaltycardsystem.domain.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository extends JpaRepository<Cashier, Long> {
        Cashier findByUsername(String username);
}
