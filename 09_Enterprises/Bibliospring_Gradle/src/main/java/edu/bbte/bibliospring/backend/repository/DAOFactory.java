package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.repository.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {

    public static DAOFactory getInstance() {
        return new JdbcDAOFactory();
    }

    public abstract UserDAO getUserDAO();

    public abstract AuthorsDAO getAuthorsDAO();

    public abstract BooksDAO getBookDAO();
}
