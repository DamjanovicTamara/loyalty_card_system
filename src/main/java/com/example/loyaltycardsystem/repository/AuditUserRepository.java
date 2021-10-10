package com.example.loyaltycardsystem.repository;

import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.domain.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditUserRepository extends JpaRepository<AuditUser, Long> {

    AuditUser findTopByOrderByLoggedTimeDesc();
}
