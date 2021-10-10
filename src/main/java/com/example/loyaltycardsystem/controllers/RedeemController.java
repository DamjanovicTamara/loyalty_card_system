package com.example.loyaltycardsystem.controllers;

import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.domain.Redeem;
import com.example.loyaltycardsystem.exceptions.RedeemValidationException;
import com.example.loyaltycardsystem.service.AuditUserService;
import com.example.loyaltycardsystem.service.PurchaseService;
import com.example.loyaltycardsystem.service.RedeemPointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedeemController {

    private static final Logger LOG = LoggerFactory.getLogger(RedeemController.class);

    @Autowired
    RedeemPointsService redeemPointsService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    AuditUserService auditUserService;

    @PostMapping(value="/redeemLastPurchase")
    public Purchase redeemLastPurchase(@RequestParam Long purchaseId, @RequestParam Redeem redeem){

            Purchase purchase = purchaseService.findById(purchaseId);

            AuditUser auditUser = auditUserService.findLastLoggedInAuditDetails();
            auditUser.setRedeem(true);
        try {
            if (redeem.equals(Redeem.SALE)) {
                int sale = redeemPointsService.calculateSaleOrWater(purchase.getPoints());
                purchase.setRedeem(Redeem.SALE);
                purchase.setRedeemAmount(sale);
                purchase.setAmount(purchase.getAmount() - sale);
                purchase.setPoints(purchase.getPoints() - sale * 100);
                auditUser.setRedeemValue(Redeem.SALE);
                auditUser.setRedeemAmount(sale);
            } else if (redeem.equals(Redeem.WATER)) {
                int packet = redeemPointsService.calculateSaleOrWater(purchase.getPoints());
                purchase.setRedeem(Redeem.WATER);
                purchase.setRedeemAmount(packet);
                purchase.setPoints(purchase.getPoints() - packet * 100);
                auditUser.setRedeemValue(Redeem.WATER);
                auditUser.setRedeemAmount(packet);
            }
            auditUserService.saveAuditUser(auditUser);
        }catch (RedeemValidationException ex){
          throw new RedeemValidationException(ex.getMessage());
        }
       return purchaseService.savePurchase(purchase);
    }
}
