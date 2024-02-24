package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User, Long> {
    public User getByUserName(String userName) throws RepositoryException;
}
