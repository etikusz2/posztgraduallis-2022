package edu.bbte.bibliospringjpa.repository;

import edu.bbte.bibliospringjpa.model.User;

public interface UserDAO extends BaseDAO<User, Long> {

    public User getByUsername(String username);
}
