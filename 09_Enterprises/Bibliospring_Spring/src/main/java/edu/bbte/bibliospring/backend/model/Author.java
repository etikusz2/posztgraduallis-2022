package edu.bbte.bibliospring.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author extends BaseEntity {
    @Column(name = "author")
    private String fullName;


    public Author() {
    }

    public String getAuthor() {
        return fullName;
    }

    public void setAuthor(String fullName) {
        this.fullName = fullName;
    }
}
