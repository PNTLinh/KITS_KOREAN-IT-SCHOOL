package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionID")
    private Integer promotionId;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @Column(name = "Description", length = 500)
    private String description;

    public Promotion() {
    }

    public Promotion(Product product, String description) {
        this.product = product;
        this.description = description;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
