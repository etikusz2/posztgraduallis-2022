package edu.bbte.bibliospringspringdata.dto.incoming;

public class BookInDTO {
    private String title;
    private String position;
    private String isbn;
    private AuthorInDTO author;

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

    public AuthorInDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorInDTO author) {
        this.author = author;
    }
}
