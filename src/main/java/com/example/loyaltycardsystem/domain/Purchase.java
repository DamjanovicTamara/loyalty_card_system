package com.example.loyaltycardsystem.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long purchaseId;

    public Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_id")
    public Cashier cashier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    public Customer customer;

    public int points;

    public Redeem redeem;

    public int redeemAmount;

    public LocalDateTime savedOn;

    public Purchase(Long purchaseId, Double amount, Cashier cashier, Customer customer, int points, LocalDateTime savedOn) {
        this.purchaseId = purchaseId;
        this.amount = amount;
        this.cashier = cashier;
        this.customer = customer;
        this.points = points;
        this.savedOn = savedOn;
    }

    public Purchase(Long purchaseId, Double amount, Cashier cashier, Customer customer, int points, Redeem redeem, int redeemAmount, LocalDateTime savedOn) {
        this.purchaseId = purchaseId;
        this.amount = amount;
        this.cashier = cashier;
        this.customer = customer;
        this.points = points;
        this.redeem = redeem;
        this.redeemAmount = redeemAmount;
        this.savedOn = savedOn;
    }

    public Purchase() {
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Redeem getRedeem() {
        return redeem;
    }

    public void setRedeem(Redeem redeem) {
        this.redeem = redeem;
    }

    public int getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(int redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public LocalDateTime getSavedOn() {
        return savedOn;
    }

    public void setSavedOn(LocalDateTime savedOn) {
        this.savedOn = savedOn;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", amount=" + amount +
                ", cashier=" + cashier +
                ", customer=" + customer +
                ", points=" + points +
                ", redeem=" + redeem +
                ", redeemAmount=" + redeemAmount +
                ", savedOn=" + savedOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return points == purchase.points && redeemAmount == purchase.redeemAmount && Objects.equals(purchaseId, purchase.purchaseId) && Objects.equals(amount, purchase.amount) && Objects.equals(cashier, purchase.cashier) && Objects.equals(customer, purchase.customer) && redeem == purchase.redeem && Objects.equals(savedOn, purchase.savedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, amount, cashier, customer, points, redeem, redeemAmount, savedOn);
    }


}
