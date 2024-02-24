package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.Authors;

public interface AuthorsDAO {
    Authors create(Authors author) throws RepositoryException;

    void delete(Long id) throws RepositoryException;

    Authors update(Authors author) throws RepositoryException;

    Authors getAuthorByName(String author) throws RepositoryException;

    Authors getByID(Long id) throws RepositoryException;
}
