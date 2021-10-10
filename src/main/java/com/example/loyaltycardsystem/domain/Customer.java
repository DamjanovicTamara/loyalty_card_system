package com.example.loyaltycardsystem.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long customerId;

    public String name;

    public String surname;

    @Column(unique = true)
    public Long mobileNumber;

    @Column(unique = true)
    public Long idNumber;

    public int totalPoints;


    public Customer(Long customerId, String name, String surname, Long mobileNumber, Long idNumber, int totalPoints) {
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return totalPoints == customer.totalPoints && Objects.equals(customerId, customer.customerId) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(idNumber, customer.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, surname, mobileNumber, idNumber, totalPoints);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", idNumber=" + idNumber +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
