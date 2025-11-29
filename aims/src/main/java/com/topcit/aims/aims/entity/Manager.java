package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerID")
    private Integer managerId;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "PasswordHash", length = 100)
    private String passwordHash;

    @Column(name = "FullName", length = 100)
    private String fullName;

    public Manager() {
    }

    public Manager(String email, String passwordHash, String fullName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
