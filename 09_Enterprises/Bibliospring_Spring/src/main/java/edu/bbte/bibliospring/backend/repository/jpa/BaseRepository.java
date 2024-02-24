package edu.bbte.bibliospring.backend.repository.jpa;

import edu.bbte.bibliospring.backend.model.BaseEntity;
import edu.bbte.bibliospring.backend.repository.BaseDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

public abstract class BaseRepository<T extends BaseEntity, I> implements BaseDAO<T, I> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliospring");
    private EntityManager entityManager = factory.createEntityManager();

    @Autowired
    private Logger LOG;

    @Override
    public T create(T entity) throws RepositoryException {
        try {
            entityManager.persist(entity);
            entityManager.flush();

            return entity;
        } catch (PersistenceException e) {
            LOG.error("Entity insertion failed.", e);
            throw new RepositoryException("Entity insertion failed.", e);
        }

    }


    @Override
    public T update(T entity) throws RepositoryException {
        return null;
    }

    @Override
    public T getByID(I id) throws RepositoryException {
        return null;
    }

    @Override
    public List<T> getAll() throws RepositoryException {
        return null;
    }
}
