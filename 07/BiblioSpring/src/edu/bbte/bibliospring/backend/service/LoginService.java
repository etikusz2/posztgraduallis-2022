package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.User;

public interface LoginService {
    public boolean login(User user);
    public User register(User user);
}
