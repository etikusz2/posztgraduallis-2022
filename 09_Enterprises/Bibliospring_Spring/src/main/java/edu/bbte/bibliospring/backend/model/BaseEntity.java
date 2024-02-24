package edu.bbte.bibliospring.backend.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return super.toString() + ID + " ";
    }
}
