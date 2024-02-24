package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.DAOFactory;
import edu.bbte.bibliospring.backend.repository.UserDAO;

public class MemoryDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new MemoryUserDAO();
    }

    @Override
    public AuthorsDAO getAuthorsDAO() {
        return new MemoryAuthorsDAO();
    }

    @Override
    public BooksDAO getBookDAO() {
        return new MemoryBooksDAO();
    }

}
