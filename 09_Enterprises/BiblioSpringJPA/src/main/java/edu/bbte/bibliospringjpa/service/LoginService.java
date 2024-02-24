package edu.bbte.bibliospringjpa.service;

import edu.bbte.bibliospringjpa.model.User;

public interface LoginService {
    public boolean login(User user);

    public User register(User user);
}
