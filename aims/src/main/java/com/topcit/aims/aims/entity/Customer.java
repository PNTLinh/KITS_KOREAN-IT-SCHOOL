package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "FullName", length = 100)
    private String fullName;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "PasswordHash", length = 100)
    private String passwordHash;

    @Column(name = "Address", length = 200)
    private String address;

    // Default constructor
    public Customer() {
    }

    // Constructor with parameters
    public Customer(String fullName, String email, String passwordHash, String address) {
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.address = address;
    }

    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}