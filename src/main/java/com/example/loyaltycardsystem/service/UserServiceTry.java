package com.example.loyaltycardsystem.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceTry {


    public String loggedInUsername(){
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ((UserDetails)principal).getUsername();
    }

}
