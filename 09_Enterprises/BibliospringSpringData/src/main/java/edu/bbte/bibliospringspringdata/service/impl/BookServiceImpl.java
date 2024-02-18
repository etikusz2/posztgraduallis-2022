package edu.bbte.bibliospringspringdata.service.impl;

import edu.bbte.bibliospringspringdata.model.Author;
import edu.bbte.bibliospringspringdata.model.Book;
import edu.bbte.bibliospringspringdata.repository.AuthorRepository;
import edu.bbte.bibliospringspringdata.repository.BookRepository;
import edu.bbte.bibliospringspringdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book update(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).get();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPosition(book.getPosition());
        existingBook.setIsbn(book.getIsbn());
        return bookRepository.saveAndFlush(existingBook);
    }

    @Override
    public boolean deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooksSortedByAuthor() {
        return bookRepository.findAll().stream()
                .sorted((book1, book2) -> book1.getAuthor()
                        .getAuthorName().compareToIgnoreCase(book2.getAuthor().getAuthorName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitleStartingWith(String title) {
        return bookRepository.findByTitleStartingWith(title);
    }

    @Override
    public List<Author> findByAuthorNameStartingWith(String authorName) {
        return authorRepository.findByAuthorNameStartingWith(authorName);
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

}
