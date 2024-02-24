package edu.bbte.bibliospring.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book extends BaseEntity {
    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "position", length = 45)
    private String position;

    @Column(name = "isbn", length = 15)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "aid", nullable = false)
    private Author author;

    public Book() {
    }

    public Long getId() {
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
