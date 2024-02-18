package edu.bbte.bibliospringspringdata.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends AuthorBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Long id;
    @Column(name = "author", length = 45)
    private String authorName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return authorName;
    }
}
