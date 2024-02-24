package edu.bbte.bibliospring.backend.model;

public class User extends BaseEntity {
    private String userName;
    private String password;

    public User() {
        // Üres konstruktor
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + userName + " " + password;
    }
}
