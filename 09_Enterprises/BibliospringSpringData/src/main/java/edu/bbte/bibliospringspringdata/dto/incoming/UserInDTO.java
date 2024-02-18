package edu.bbte.bibliospringspringdata.dto.incoming;

import java.io.Serializable;

public class UserInDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = String.valueOf(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
