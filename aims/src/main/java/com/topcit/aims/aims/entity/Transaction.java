package com.topcit.aims.aims.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Amount", nullable = false)
    private Double amount;

    @Column(name = "PaymentMethod", length = 100)
    private String paymentMethod;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    // Một Transaction thuộc về một Order
    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private Order order;

    public Transaction() {}

    public Transaction(Double amount, String paymentMethod, String status, LocalDateTime createdAt, Order order) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.createdAt = createdAt;
        this.order = order;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
