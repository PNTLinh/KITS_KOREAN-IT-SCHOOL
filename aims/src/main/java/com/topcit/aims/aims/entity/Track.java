package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Length")
    private Integer length; // phút hoặc giây

    // Một Track thuộc về một CD
    @ManyToOne
    @JoinColumn(name = "CDID", nullable = false)
    private CD cd;

    public Track() {}

    public Track(String title, Integer length, CD cd) {
        this.title = title;
        this.length = length;
        this.cd = cd;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }
}
