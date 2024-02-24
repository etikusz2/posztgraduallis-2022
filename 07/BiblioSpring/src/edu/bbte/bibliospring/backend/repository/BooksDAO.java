package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.Books;

import java.util.List;


public interface BooksDAO {
    Books create(Books book) throws RepositoryException;
    void delete(Long id) throws RepositoryException;

    Books getByID(Long id) throws RepositoryException;

    Long getIdByTitle(String title) throws RepositoryException;

    Books update(Books book) throws RepositoryException;

    List<Books> getAll() throws RepositoryException;
    List<Books> searchByTitleOrAuthor(String searchTerm) throws RepositoryException;

}
