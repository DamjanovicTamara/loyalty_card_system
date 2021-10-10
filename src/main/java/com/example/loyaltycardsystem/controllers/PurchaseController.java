package com.example.loyaltycardsystem.controllers;
import com.example.loyaltycardsystem.configuration.SecurityUtils;
import com.example.loyaltycardsystem.domain.AuditUser;
import com.example.loyaltycardsystem.domain.Customer;
import com.example.loyaltycardsystem.domain.Purchase;
import com.example.loyaltycardsystem.exceptions.PurchaseNotFoundException;
import com.example.loyaltycardsystem.exceptions.PurchaseServiceException;
import com.example.loyaltycardsystem.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private static final Logger LOG = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    CustomerService customerService;

    @Autowired
    RewardPointsService rewardPointsService;


    @Autowired
    AuditUserService auditUserService;

    @GetMapping
    public  ResponseEntity<List<Purchase>> findAll() {
        List<Purchase> purchases;
        try {
            purchases=purchaseService.findAll();
        }catch (PurchaseNotFoundException ex) {
            throw new PurchaseNotFoundException(ex.getMessage());
        }catch (PurchaseServiceException e){
            throw new PurchaseNotFoundException(e.getMessage());
        }
        return new ResponseEntity<>(purchases, HttpStatus.OK);

    }

    @PostMapping(value = "/createPurchase",produces = "application/json")
    public Purchase createPurchase(@RequestBody Purchase purchase,
                                   @RequestParam Long customerId){

      //  com.example.loyaltycardsystem.domain.User userDetails = SecurityUtils.getCurrentUserDetails();

        AuditUser auditUser = auditUserService.findLastLoggedInAuditDetails();
        purchase.setCashier(auditUser.getCashier());

        int rewardPoints = rewardPointsService.calculatePurchasePoints(purchase.amount);
        purchase.setPoints(rewardPoints);
        purchase.setSavedOn(LocalDateTime.now());

        Customer customer= customerService.findById(customerId);
        purchase.setCustomer(customer);

        Purchase newPurchase = purchaseService.savePurchase(purchase);
       // redirectAttributes.addFlashAttribute("flash",new FlashMessage("Purchase successfully made!",FlashMessage.Status.SUCCESS));

        //Add calculated purchased points to sum of total points
        customer.setTotalPoints(customer.getTotalPoints()+purchase.getPoints());
        customerService.saveCustomer(customer);
        //Save other info for audit
        auditUser.setPurchase(newPurchase);
        auditUser.setLoggedTime(LocalDateTime.now());
        auditUserService.saveAuditUser(auditUser);

        return newPurchase;
    }
}
