package com.topcit.aims.aims.dto.request;

public class CustomerCreationRequest {
    private String fullName;
    private String email;
    private String passwordHash;
    private String address;
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {this.email = email;}
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {this.passwordHash = passwordHash;}
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {this.address = address;}
}
