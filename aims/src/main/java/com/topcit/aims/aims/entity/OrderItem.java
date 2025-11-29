package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", nullable = false)
    private Double price;

    // Một Order có nhiều OrderItem
    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private Order order;

    // Một Product có thể nằm trong nhiều OrderItem
    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    public OrderItem() {}

    public OrderItem(Integer quantity, Double price, Order order, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
