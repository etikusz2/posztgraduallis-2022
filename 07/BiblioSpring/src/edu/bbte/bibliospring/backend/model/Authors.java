package edu.bbte.bibliospring.backend.model;

public class Authors extends BaseEntity {
    private String fullName;

    public Authors() {
    }

    public String getAuthor() {
        return fullName;
    }

    public void setAuthor(String fullName) {
        this.fullName = fullName;
    }
}
