package com.example.loyaltycardsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cashier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long cashierId;

    public String username;

    public Cashier(Long cashierId, String username) {
        this.cashierId = cashierId;
        this.username = username;
    }

    public Cashier() {
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
