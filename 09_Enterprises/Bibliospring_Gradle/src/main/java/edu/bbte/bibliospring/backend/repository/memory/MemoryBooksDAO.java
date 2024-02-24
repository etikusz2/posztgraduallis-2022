package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.model.Books;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryBooksDAO implements BooksDAO {
    private final ConcurrentHashMap<Long, Books> books;
    private final AtomicLong idGenerator;

    public MemoryBooksDAO() {
        books = new ConcurrentHashMap<>();
        idGenerator = new AtomicLong();
    }

    @Override
    public Books create(Books book) {
        book.setId(idGenerator.incrementAndGet());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public void delete(Long id) {
        books.remove(id);
    }

    @Override
    public Books getByID(Long id) throws RepositoryException {
        if (books.containsKey(id)) {
            return books.get(id);
        } else {
            throw new RepositoryException("Book not found with ID: " + id);
        }
    }

    @Override
    public Long getIdByTitle(String title) throws RepositoryException {
        for (Books book : books.values()) {
            if (book.getTitle().equals(title)) {
                return book.getId();
            }
        }
        throw new RepositoryException("Book not found with title: " + title);
    }

    @Override
    public Books update(Books book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        } else {
            throw new RepositoryException("Book not found for update with ID: " + book.getId());
        }
        return book;
    }

    @Override
    public List<Books> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Books> searchByTitleOrAuthor(String searchTerm) throws RepositoryException {
        List<Books> searchResults = new ArrayList<>();
        for (Books book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(book);
            } else {
                Authors author = book.getAuthor();
                if (author != null && author.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(book);
                }
            }
        }
        return searchResults;
    }
}
