package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Books;


import java.util.List;

public interface BooksService {
    public Books create(Books book);
    public void delete(Long id);
    public void update(Books book);
    List<Books> getAllBooks();
}
