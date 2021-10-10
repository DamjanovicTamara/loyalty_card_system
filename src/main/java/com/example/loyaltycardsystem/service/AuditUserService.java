package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.repository.AuditUserRepository;

public interface AuditUserService {

    AuditUser saveAuditUser(AuditUser auditUser);

    AuditUser findLastLoggedInAuditDetails();
}
