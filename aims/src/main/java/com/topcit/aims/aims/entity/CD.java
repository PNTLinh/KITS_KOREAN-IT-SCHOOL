package com.topcit.aims.aims.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CD")
@PrimaryKeyJoinColumn(name = "ProductID") // liên kết với Product
public class CD extends Product {

    @Column(name = "Artist", length = 255)
    private String artist;

    @Column(name = "Director", length = 255)
    private String director;

    // Một CD có nhiều Track
    @OneToMany(mappedBy = "cd", cascade = CascadeType.ALL)
    private List<Track> tracks;

    public CD() {}

    public CD(String artist, String director) {
        this.artist = artist;
        this.director = director;
    }

    // --- Getters & Setters ---
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
