package edu.bbte.bibliospringspringdata.dto.outgoing;

public class BookOutDTO {
    private String uid;
    private Long id;
    private String title;
    private String position;
    private String isbn;
    private AuthorOutDTO author;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AuthorOutDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOutDTO author) {
        this.author = author;
    }
}
