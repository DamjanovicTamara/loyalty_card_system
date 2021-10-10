package com.example.loyaltycardsystem.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public final class SecurityUtils {
    private SecurityUtils() {
    }


    public static com.example.loyaltycardsystem.domain.User getCurrentUserDetails() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return getCurrentUserDetails(authentication);
    }

    public static com.example.loyaltycardsystem.domain.User getCurrentUserDetails(Authentication authentication) {
        com.example.loyaltycardsystem.domain.User userDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof com.example.loyaltycardsystem.domain.User) {
            userDetails = (com.example.loyaltycardsystem.domain.User) authentication.getPrincipal();
        }
        return userDetails;
    }
}
