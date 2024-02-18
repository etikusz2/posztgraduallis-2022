package edu.bbte.bibliospringspringdata.service;

import edu.bbte.bibliospringspringdata.model.Author;
import edu.bbte.bibliospringspringdata.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book update(Book book);

    boolean deleteById(Long id);

    List<Book> getAll();

    Book getById(Long id);

    List<Book> getAllBooksSortedByAuthor();

    List<Book> findByTitleStartingWith(String title);

    List<Author> findByAuthorNameStartingWith(String name);

    List<Book> findBooksByAuthor(Author author);
}
