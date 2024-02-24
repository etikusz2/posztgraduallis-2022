package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.Author;

public interface AuthorDAO extends BaseDAO<Author, Long>{

    Author getAuthorByName(String author) throws RepositoryException;

}
