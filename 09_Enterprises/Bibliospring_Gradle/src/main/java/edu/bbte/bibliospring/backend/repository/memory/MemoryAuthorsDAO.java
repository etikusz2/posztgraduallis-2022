// MemoryAuthorsDAO.java

package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryAuthorsDAO implements AuthorsDAO {
    private final ConcurrentHashMap<Long, Authors> authors;
    private final AtomicLong idGenerator;

    public MemoryAuthorsDAO() {
        authors = new ConcurrentHashMap<>();
        idGenerator = new AtomicLong();
    }

    @Override
    public Authors create(Authors author) {
        author.setId(idGenerator.incrementAndGet());
        authors.put(author.getId(), author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authors.remove(id);
    }

    @Override
    public Authors update(Authors author) {
        if (authors.containsKey(author.getId())) {
            authors.put(author.getId(), author);
        } else {
            throw new RepositoryException("Author not found for update with ID: " + author.getId());
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
