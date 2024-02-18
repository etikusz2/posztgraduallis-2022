package edu.bbte.bibliospringspringdata.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AuthorBaseEntity extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
