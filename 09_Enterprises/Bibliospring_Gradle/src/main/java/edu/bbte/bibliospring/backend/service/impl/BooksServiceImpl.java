package edu.bbte.bibliospring.backend.service.impl;

import edu.bbte.bibliospring.backend.model.Books;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.DAOFactory;
import edu.bbte.bibliospring.backend.service.BooksService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    private static final Logger LOG = LoggerFactory.getLogger(BooksServiceImpl.class);
    private final BooksDAO booksDAO = DAOFactory.getInstance().getBookDAO();

    @Override
    public Books create(Books book) {
        try {
            return booksDAO.create(book);
        } catch (ServiceException e) {
            LOG.error("Book creation failed.");
            throw new ServiceException("Book creation failed.", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            booksDAO.delete(id);
        } catch (ServiceException e) {
            LOG.error("Book deletion failed.");
            throw new ServiceException("Book deletion failed.", e);
        }
    }

    @Override
    public void update(Books book) {
        try {
            booksDAO.update(book);
        } catch (ServiceException e) {
            LOG.error("Book update failed.");
            throw new ServiceException("Book update failed.", e);
        }
    }

    @Override
    public List<Books> getAllBooks() {
        try {
            return booksDAO.getAll();
        } catch (ServiceException e) {
            LOG.error("Error fetching books", e);
            throw new ServiceException("Error fetching books");
        }
    }

}

