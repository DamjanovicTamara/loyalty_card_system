package com.example.loyaltycardsystem.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AuditUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long auditId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_id")
    public Cashier cashier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    public Purchase purchase;

    public Boolean redeem;

    public Redeem redeemValue;

    public int redeemAmount;

    public LocalDateTime loggedTime;

    public AuditUser() {
    }

    public AuditUser(Long auditId, Cashier cashier, Purchase purchase, Boolean redeem, Redeem redeemValue, int redeemAmount, LocalDateTime timestamp) {
        this.auditId = auditId;
        this.cashier = cashier;
        this.purchase = purchase;
        this.redeem = redeem;
        this.redeemValue = redeemValue;
        this.redeemAmount = redeemAmount;
        this.loggedTime = timestamp;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Boolean getRedeem() {
        return redeem;
    }

    public void setRedeem(Boolean redeem) {
        this.redeem = redeem;
    }

    public Redeem getRedeemValue() {
        return redeemValue;
    }

    public void setRedeemValue(Redeem redeemValue) {
        this.redeemValue = redeemValue;
    }

    public int getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(int redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public LocalDateTime getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(LocalDateTime loggedTime) {
        this.loggedTime = loggedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditUser auditUser = (AuditUser) o;
        return Objects.equals(auditId, auditUser.auditId) && Objects.equals(cashier, auditUser.cashier) && Objects.equals(purchase, auditUser.purchase) && Objects.equals(redeem, auditUser.redeem) && redeemValue == auditUser.redeemValue && Objects.equals(redeemAmount, auditUser.redeemAmount) && Objects.equals(loggedTime, auditUser.loggedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditId, cashier, purchase, redeem, redeemValue, redeemAmount, loggedTime);
    }

    @Override
    public String toString() {
        return "AuditUser{" +
                "auditId=" + auditId +
                ", cashier=" + cashier +
                ", purchase=" + purchase +
                ", redeem=" + redeem +
                ", redeemValue=" + redeemValue +
                ", redeemAmount=" + redeemAmount +
                ", timestamp=" + loggedTime +
                '}';
    }
}
