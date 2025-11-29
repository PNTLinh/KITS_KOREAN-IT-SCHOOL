package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DVD")
@PrimaryKeyJoinColumn(name = "ProductID") // liên kết với Product
public class DVD extends Product {

    @Column(name = "Director", length = 255)
    private String director;

    @Column(name = "Length")
    private Integer length;

    public DVD() {}

    public DVD(String director, Integer length) {
        this.director = director;
        this.length = length;
    }

    // --- Getters & Setters ---
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
