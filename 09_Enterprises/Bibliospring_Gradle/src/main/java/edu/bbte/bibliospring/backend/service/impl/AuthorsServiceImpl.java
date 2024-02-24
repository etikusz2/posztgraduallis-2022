package edu.bbte.bibliospring.backend.service.impl;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.DAOFactory;
import edu.bbte.bibliospring.backend.service.AuthorsService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthorsServiceImpl implements AuthorsService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorsServiceImpl.class);
    private final AuthorsDAO authorsDAO = DAOFactory.getInstance().getAuthorsDAO();

    @Override
    public Authors create(Authors author) {
        try {
            return authorsDAO.create(author);
        } catch (ServiceException e) {
            LOG.error("Author creation failed.");
            throw new ServiceException("Author creation failed.", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            authorsDAO.delete(id);
        } catch (ServiceException e) {
            LOG.error("Author deletion failed.");
            throw new ServiceException("Author deletion failed.", e);
        }
    }

    @Override
    public void update(Authors author) {
        try {
            authorsDAO.update(author);
        } catch (ServiceException e) {
            LOG.error("Author update failed.");
            throw new ServiceException("Author update failed.", e);
        }
    }

    @Override
    public Authors getAuthorByName(String fullName) {
        try {
            return authorsDAO.getAuthorByName(fullName);
        } catch (ServiceException e) {
            return null;
        }
    }
}
