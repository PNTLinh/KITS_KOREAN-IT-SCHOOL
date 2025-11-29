package com.topcit.aims.aims.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "VAT", precision = 10, scale = 2)
    private BigDecimal vat;

    @Column(name = "total_amount", precision = 15, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "shipping_fee")
    private  BigDecimal shippingFee;

    @Column(name = "status")
    private String status;

    @Column(name = "shipping_address")
    private String shippingAddress;

    public Order() {}

    public Order(Customer customer, BigDecimal vat, BigDecimal totalAmount, LocalDateTime orderDate,BigDecimal shippingFee, String status, String shippingAddress) {
        this.customer = customer;
        this.vat = vat;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.shippingFee = shippingFee;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getShippingFee(){
        return shippingFee;
    }
    public void setShippingFee(BigDecimal shippingFee){
        this.shippingFee = shippingFee;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getShippingAddress(){
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress){
        this.shippingAddress = shippingAddress;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
