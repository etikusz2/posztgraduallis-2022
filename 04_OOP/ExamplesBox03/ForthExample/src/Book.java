import java.io.*;

public class Book implements Serializable {
    private String author;
    private String title;
    private String publisher;
    private String date;
    private String shelf;
    private String position;

    public Book(String author, String title, String publisher, String date, String shelf, String position) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.date = date;
        this.shelf = shelf;
        this.position = position;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}