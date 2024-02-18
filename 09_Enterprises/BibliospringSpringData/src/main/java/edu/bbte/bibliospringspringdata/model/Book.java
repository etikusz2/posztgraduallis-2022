package edu.bbte.bibliospringspringdata.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "position", length = 45)
    private String position;

    @Column(name = "isbn", length = 15)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "aid", nullable = false)
    private Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
