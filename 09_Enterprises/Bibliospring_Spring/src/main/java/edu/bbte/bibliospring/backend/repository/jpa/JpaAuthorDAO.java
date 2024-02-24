package edu.bbte.bibliospring.backend.repository.jpa;

import edu.bbte.bibliospring.backend.model.Author;
import edu.bbte.bibliospring.backend.repository.AuthorDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("jpa")
public class JpaAuthorDAO implements AuthorDAO {

    @Override
    public Author create(Author entity) throws RepositoryException {
        return null;
    }

    @Override
    public void delete(Long id) throws RepositoryException {

    }

    @Override
    public Author update(Author entity) throws RepositoryException {
        return null;
    }

    @Override
    public Author getByID(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public List<Author> getAll() throws RepositoryException {
        return null;
    }

    @Override
    public Author getAuthorByName(String author) throws RepositoryException {
        return null;
    }
}
