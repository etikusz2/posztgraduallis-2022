package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.User;

import java.util.List;

public interface UserDAO {
    User create(User user) throws RepositoryException;

    User getByID(Long id) throws RepositoryException;

    List<User> getAll() throws RepositoryException;

    User getByUserName(String userName) throws RepositoryException;
}
