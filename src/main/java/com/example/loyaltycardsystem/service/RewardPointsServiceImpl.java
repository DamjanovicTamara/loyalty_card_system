package com.example.loyaltycardsystem.service;

import org.springframework.stereotype.Service;

@Service
public class RewardPointsServiceImpl implements RewardPointsService {

    int purchasePoints = 0;
    @Override
    public int calculatePurchasePoints(Double totalPurchaseAmount) {
        if(totalPurchaseAmount>50) {
            purchasePoints =((totalPurchaseAmount.intValue()/50))*10;
        }
        return purchasePoints;
    }
}
