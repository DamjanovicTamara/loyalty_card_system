package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.exceptions.PurchaseNotFoundException;
import com.example.loyaltycardsystem.exceptions.PurchaseServiceException;
import com.example.loyaltycardsystem.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> findAll() {
       return purchaseRepository.findAll();
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findById(Long id) {
        return purchaseRepository.getById(id);
    }

}
