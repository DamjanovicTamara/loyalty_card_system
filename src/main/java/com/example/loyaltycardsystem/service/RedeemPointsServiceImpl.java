package com.example.loyaltycardsystem.service;

import org.springframework.stereotype.Service;

@Service
public class RedeemPointsServiceImpl implements RedeemPointsService{

    @Override
    public int calculateSaleOrWater(int purchasePoints) {

        return purchasePoints/100;
    }


}
