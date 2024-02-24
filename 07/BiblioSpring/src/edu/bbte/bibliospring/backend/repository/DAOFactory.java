package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.repository.jdbc.JdbcBooksDAO;
import edu.bbte.bibliospring.backend.repository.jdbc.JdbcDAOFactory;
import edu.bbte.bibliospring.backend.repository.memory.MemoryDAOFactory;

public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();

    public static DAOFactory getInstance(){
        return new JdbcDAOFactory();
    };

    public abstract AuthorsDAO getAuthorsDAO();

    public abstract BooksDAO getBookDAO();
}
