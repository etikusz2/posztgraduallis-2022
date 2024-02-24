package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.Author;
import edu.bbte.bibliospring.backend.repository.AuthorDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("memory")
public class MemoryAuthorDAO implements AuthorDAO {
    private ConcurrentHashMap<Long, Author> authors;
    private AtomicLong IDgenerator;

    public MemoryAuthorDAO() {
        authors = new ConcurrentHashMap<>();
        IDgenerator = new AtomicLong();
    }

    @Override
    public Author create(Author author) {
        author.setID(IDgenerator.incrementAndGet());
        authors.put(author.getID(), author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authors.remove(id);
    }

    @Override
    public Author update(Author author) {
        if (authors.containsKey(author.getID())) {
            authors.put(author.getID(), author);
        } else {
            throw new RepositoryException("Author not found for update with ID: " + author.getID());
        }
        return author;
    }

    @Override
    public Author getAuthorByName(String fullName) {
        for (Author author : authors.values()) {
            if (author.getAuthor().equals(fullName)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public Author getByID(Long id) {
        return authors.get(id);
    }

    @Override
    public List<Author> getAll() throws RepositoryException {
        return null;
    }
}
