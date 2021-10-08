package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.domain.Redeem;
import com.example.loyaltycardsystem.service.PurchaseService;
import com.example.loyaltycardsystem.service.RedeemPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedeemController {
    @Autowired
    RedeemPointsService redeemPointsService;
    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value="/redeemLastPurchase")
    public Purchase redeemLastPurchase(@PathVariable Long purchaseId, @RequestParam Redeem redeem){

        Purchase purchase = purchaseService.findById(purchaseId);

        if (redeem.equals( Redeem.SALE)) {
            int sale=redeemPointsService.calculateSaleOrWater(purchase.getPoints());
            purchase.setRedeem(Redeem.SALE);
            purchase.setRedeemAmount(sale);
            purchase.setAmount(purchase.getAmount()-sale);
            purchase.setPoints(purchase.getPoints()-sale*100);

        }else if (redeem.equals(Redeem.WATER)){
            int packet = redeemPointsService.calculateSaleOrWater(purchase.getPoints());
            purchase.setRedeem(Redeem.WATER);
            purchase.setRedeemAmount(packet);
            purchase.setPoints(purchase.getPoints()-packet*100);
        }
       return purchaseService.savePurchase(purchase);
    }
}
