package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.Author;
import edu.bbte.bibliospring.backend.model.Book;
import edu.bbte.bibliospring.backend.repository.BookDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("memory") public class MemoryBookDAO implements BookDAO {
    private ConcurrentHashMap<Long, Book> books;
    private AtomicLong IDgenerator;

    public MemoryBookDAO() {
        books = new ConcurrentHashMap<>();
        IDgenerator = new AtomicLong();
    }

    @Override
    public Book create(Book book) {
        book.setID(IDgenerator.incrementAndGet());
        books.put(book.getID(), book);
        return book;
    }

    @Override
    public void delete(Long id) {
        books.remove(id);
    }

    @Override
    public Book getByID(Long id) throws RepositoryException {
        if (books.containsKey(id)) {
            return books.get(id);
        } else {
            throw new RepositoryException("Book not found with ID: " + id);
        }
    }

    @Override
    public Long getIdByTitle(String title) throws RepositoryException {
        for (Book book : books.values()) {
            if (book.getTitle().equals(title)) {
                return book.getID();
            }
        }
        throw new RepositoryException("Book not found with title: " + title);
    }

    @Override
    public Book update(Book book) {
        if (books.containsKey(book.getID())) {
            books.put(book.getID(), book);
        } else {
            throw new RepositoryException("Book not found for update with ID: " + book.getID());
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> searchByTitleOrAuthor(String searchTerm) throws RepositoryException {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(book);
            } else {
                Author author = book.getAuthor();
                if (author != null && author.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(book);
                }
            }
        }
        return searchResults;
    }
}
