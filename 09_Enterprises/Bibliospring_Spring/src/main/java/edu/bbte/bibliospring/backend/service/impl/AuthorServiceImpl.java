package edu.bbte.bibliospring.backend.service.impl;

import edu.bbte.bibliospring.backend.model.Author;
import edu.bbte.bibliospring.backend.repository.AuthorDAO;
import edu.bbte.bibliospring.backend.service.AuthorService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private Logger LOG;

    @Override
    public Author create(Author author) {
        try {
            return authorDAO.create(author);
        } catch (ServiceException e) {
            LOG.error("Author creation failed.");
            throw new ServiceException("Author creation failed.", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            authorDAO.delete(id);
        } catch (ServiceException e) {
            LOG.error("Author deletion failed.");
            throw new  ServiceException("Author deletion failed.", e);
        }
    }

    @Override
    public void update(Author author) {
        try {
            authorDAO.update(author);
        } catch (ServiceException e) {
            LOG.error("Author update failed.");
            throw new ServiceException("Author update failed.", e);
        }
    }

    @Override
    public Author getAuthorByName(String fullName) {
        try {
            return authorDAO.getAuthorByName(fullName);
        } catch (ServiceException e) {
            return null;
        }
    }
}
