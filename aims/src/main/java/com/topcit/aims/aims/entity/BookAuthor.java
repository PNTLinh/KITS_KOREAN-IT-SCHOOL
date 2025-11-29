package com.topcit.aims.aims.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "BookAuthor")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Integer bookId;

    @Column(name = "AuthorName", length = 200)
    private String authorName;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Book book;

    public BookAuthor() {
    }

    public BookAuthor(String authorName, Book book) {
        this.authorName = authorName;
        this.book = book;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
