package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.User;

public interface LoginService {
    boolean login(User user);

    User register(User user);
}
