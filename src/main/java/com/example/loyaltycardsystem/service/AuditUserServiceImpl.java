package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.repository.AuditUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditUserServiceImpl implements AuditUserService{

    @Autowired
    AuditUserRepository auditUserRepository;

    @Override
    public AuditUser saveAuditUser(AuditUser auditUser) {
        return auditUserRepository.save(auditUser);
    }

    @Override
    public AuditUser findLastLoggedInAuditDetails() {
        return auditUserRepository.findTopByOrderByLoggedTimeDesc();
    }

}
