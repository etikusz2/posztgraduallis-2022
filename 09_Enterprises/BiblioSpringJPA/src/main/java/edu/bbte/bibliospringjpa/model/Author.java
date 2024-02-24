package edu.bbte.bibliospringjpa.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Author extends BaseEntity {
    @Column(name = "author")
    private String fullName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author() {
    }

    public String getAuthor() {
        return fullName;
    }

    public void setAuthor(String fullName) {
        this.fullName = fullName;
    }
}
