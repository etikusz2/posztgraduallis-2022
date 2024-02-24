package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Books;

import java.util.List;

public interface BooksService {
    Books create(Books book);

    void delete(Long id);

    void update(Books book);

    List<Books> getAllBooks();
}
