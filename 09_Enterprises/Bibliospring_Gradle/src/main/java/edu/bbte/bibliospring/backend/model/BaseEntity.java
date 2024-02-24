package edu.bbte.bibliospring.backend.model;

public abstract class BaseEntity extends AbtractModel {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + id + " ";
    }
}
