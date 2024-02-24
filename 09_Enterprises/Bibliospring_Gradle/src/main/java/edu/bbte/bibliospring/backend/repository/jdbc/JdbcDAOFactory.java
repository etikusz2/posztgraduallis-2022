package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.DAOFactory;
import edu.bbte.bibliospring.backend.repository.UserDAO;

public class JdbcDAOFactory extends DAOFactory {
    private AuthorsDAO authorDAO;
    private BooksDAO bookDAO;

    @Override
    public UserDAO getUserDAO() {
        return new JdbcUserDAO();
    }

    @Override
    public BooksDAO getBookDAO() {
        if (bookDAO == null) {
            bookDAO = new JdbcBooksDAO(getAuthorsDAO());
        }
        return bookDAO;
    }

    @Override
    public AuthorsDAO getAuthorsDAO() {
        if (authorDAO == null) {
            authorDAO = new JdbcAuthorsDAO();
        }
        return authorDAO;
    }
}

