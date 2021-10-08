package com.example.loyaltycardsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LoyaltyCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoyaltyCardApplication.class, args);
    }
}
