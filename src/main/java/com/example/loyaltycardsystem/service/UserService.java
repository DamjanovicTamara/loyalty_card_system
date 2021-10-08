package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    UserDetails getCurrentUser();
}
