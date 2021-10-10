package com.example.loyaltycardsystem.service;

import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.exceptions.PurchaseNotFoundException;

import java.util.List;

public interface PurchaseService {

    List<Purchase> findAll();

     Purchase savePurchase(Purchase purchase);

     Purchase findById(Long id);

}
