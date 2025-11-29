package com.topcit.aims.aims.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.JOINED) // để CD/DVD/Book kế thừa
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productId;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Category", nullable = false, length = 100)
    private String category;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "AddedDate")
    private LocalDate addedDate;

    // Sử dụng enum ProductType
    @Enumerated(EnumType.STRING) // Lưu vào DB dưới dạng chuỗi: BOOK, CD, DVD
    @Column(name = "ProductType", nullable = false, length = 20)
    private ProductType productType;

    // --- Relationships ---
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Promotion> promotions;

    // --- Constructors ---
    public Product() {}

    public Product(String title, String category, BigDecimal price, Integer quantity, LocalDate addedDate, ProductType productType) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.addedDate = addedDate;
        this.productType = productType;
    }

    // --- Getters & Setters ---
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
