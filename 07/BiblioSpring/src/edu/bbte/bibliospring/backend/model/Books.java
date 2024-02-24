package edu.bbte.bibliospring.backend.model;

public class Books extends BaseEntity {
    private String title;
    private Authors author;
    private String position;
    private String isbn;

    public Books() {
    }

    public String getTitle() {
        return title;
    }

    public Authors getAuthor() {
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

    public void setAuthor(Authors author) {
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
