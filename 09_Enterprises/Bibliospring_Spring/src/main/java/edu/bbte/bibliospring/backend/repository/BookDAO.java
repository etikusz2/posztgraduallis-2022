package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.Book;

import java.util.List;


public interface BookDAO extends BaseDAO<Book, Long>{


    Long getIdByTitle(String title) throws RepositoryException;


    List<Book> searchByTitleOrAuthor(String searchTerm) throws RepositoryException;

}
