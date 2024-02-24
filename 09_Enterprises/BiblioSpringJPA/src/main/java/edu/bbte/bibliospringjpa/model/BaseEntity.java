package edu.bbte.bibliospringjpa.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getID() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
