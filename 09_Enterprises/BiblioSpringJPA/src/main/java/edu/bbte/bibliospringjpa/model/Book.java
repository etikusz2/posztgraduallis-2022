package edu.bbte.bibliospringjpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book extends BaseEntity {
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "aid")
    private Author author;
    @Column(name = "position")
    private String position;
    @Column(name = "isbn")
    private String isbn;

    public Book() {
    }

    public Long getID() {
        return super.getID();
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPosition() {
        return position;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return title + ", Position: " + position + ", ISBN: " + isbn;
    }
}
