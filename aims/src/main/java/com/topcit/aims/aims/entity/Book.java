package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "ProductID")
    private Integer productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "ContentLength")
    private Integer contentLength;

    public Book() {
    }

    public Book(Product product, Integer contentLength) {
        this.product = product;
        this.contentLength = contentLength;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getContentLength() {
        return contentLength;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }
}
