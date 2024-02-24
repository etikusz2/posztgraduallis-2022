package edu.bbte.bibliospring.backend.repository.jpa;

import edu.bbte.bibliospring.backend.model.Book;
import edu.bbte.bibliospring.backend.repository.BookDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("jpa")
public class JpaBookDAO implements BookDAO {

    @Override
    public Book create(Book entity) throws RepositoryException {
        return null;
    }

    @Override
    public void delete(Long id) throws RepositoryException {

    }

    @Override
    public Book update(Book entity) throws RepositoryException {
        return null;
    }

    @Override
    public Book getByID(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public List<Book> getAll() throws RepositoryException {
        return null;
    }


    @Override
    public Long getIdByTitle(String title) throws RepositoryException {
        return null;
    }

    @Override
    public List<Book> searchByTitleOrAuthor(String searchTerm) throws RepositoryException {
        return null;
    }
}
