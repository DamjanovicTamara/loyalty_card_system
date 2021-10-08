package com.example.loyaltycardsystem.domain;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    public Long customerId;

    public String name;

    public String surname;

    @Column(unique = true)
    public Long mobileNumber;

    @Column(unique = true)
    public Long idNumber;

    public Long totalPoints;


    public Customer(Long customerId, String name, String surname, Long mobileNumber, Long idNumber, Long totalPoints) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.mobileNumber = mobileNumber;
        this.idNumber = idNumber;
        this.totalPoints = totalPoints;
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
