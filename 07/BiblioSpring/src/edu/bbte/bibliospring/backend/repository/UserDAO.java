package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.User;

import java.util.List;

public interface UserDAO {
    public User create(User user) throws RepositoryException;

    public User getByID(Long ID) throws RepositoryException;

    public List<User> getAll() throws RepositoryException;
    public User getByUserName(String userName) throws RepositoryException;
}
