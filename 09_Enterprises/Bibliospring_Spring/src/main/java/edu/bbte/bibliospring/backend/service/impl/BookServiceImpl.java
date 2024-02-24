package edu.bbte.bibliospring.backend.service.impl;

import edu.bbte.bibliospring.backend.model.Book;
import edu.bbte.bibliospring.backend.repository.BookDAO;
import edu.bbte.bibliospring.backend.service.BookService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private Logger LOG;

    @Override
    public Book create(Book book) {
        try {
            return bookDAO.create(book);
        } catch (ServiceException e) {
            LOG.error("Book creation failed.");
            throw new ServiceException("Book creation failed.", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            bookDAO.delete(id);
        } catch (ServiceException e) {
            LOG.error("Book deletion failed.");
            throw new ServiceException("Book deletion failed.", e);
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookDAO.update(book);
        } catch (ServiceException e) {
            LOG.error("Book update failed.");
            throw new ServiceException("Book update failed.", e);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        try {
            return bookDAO.getAll();
        } catch (ServiceException e) {
            LOG.error("Error fetching books", e);
            throw new ServiceException("Error fetching books");
        }
    }

    @Override
    public Book getByID(Long id) {
        try {
            return bookDAO.getByID(id);
        }catch (ServiceException e){
            LOG.error("Error getting book by id", e);
            throw new ServiceException("Error getting bokk by id");
        }
    }

    @Override
    public List<Book> searchByTitleOrAuthor(String searchTerm) {
        try {
            return bookDAO.searchByTitleOrAuthor(searchTerm);
        }catch (ServiceException e){
            LOG.error("Error seaching by title or author", e);
            throw new ServiceException("Error seaching by title or author");
        }
    }

}

