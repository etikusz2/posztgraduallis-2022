package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Book;


import java.util.List;

public interface BookService {
    public Book create(Book book);
    public void delete(Long id);
    public void update(Book book);
    List<Book> getAllBooks();
    public Book getByID(Long id);
    List<Book> searchByTitleOrAuthor(String searchTerm);
}
