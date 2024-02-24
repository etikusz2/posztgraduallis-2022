// MemoryAuthorsDAO.java

package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryAuthorsDAO implements AuthorsDAO {
    private ConcurrentHashMap<Long, Authors> authors;
    private AtomicLong IDgenerator;

    public MemoryAuthorsDAO() {
        authors = new ConcurrentHashMap<>();
        IDgenerator = new AtomicLong();
    }

    @Override
    public Authors create(Authors author) {
        author.setID(IDgenerator.incrementAndGet());
        authors.put(author.getID(), author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authors.remove(id);
    }

    @Override
    public Authors update(Authors author) {
        if (authors.containsKey(author.getID())) {
            authors.put(author.getID(), author);
        } else {
            throw new RepositoryException("Author not found for update with ID: " + author.getID());
        }
        return author;
    }

    @Override
    public Authors getAuthorByName(String fullName) {
        for (Authors author : authors.values()) {
            if (author.getAuthor().equals(fullName)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public Authors getByID(Long id) {
        return authors.get(id);
    }
}
