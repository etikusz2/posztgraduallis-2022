package edu.bbte.bibliospring.backend.model;

public abstract class BaseEntity extends AbtractModel{
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
