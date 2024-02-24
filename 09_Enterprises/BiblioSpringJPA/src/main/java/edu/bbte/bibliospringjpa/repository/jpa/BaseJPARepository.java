package edu.bbte.bibliospringjpa.repository.jpa;

import edu.bbte.bibliospringjpa.model.AbstractModel;
import edu.bbte.bibliospringjpa.repository.BaseDAO;
import edu.bbte.bibliospringjpa.repository.RepositoryException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BaseJPARepository<T extends AbstractModel, I> implements BaseDAO<T, I> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private Logger LOG;

    private Class<T> clazz;

    public BaseJPARepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T create(T entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        } catch (PersistenceException e) {
            LOG.error("Entity creation failed!", e);
            throw new RepositoryException("Entity creation failed!", e);
        }
    }

    @Override
    public T getById(I id) {
        try {
            return entityManager.find(clazz, id);
        } catch (PersistenceException e) {
            LOG.error("Entity search failed!", e);
            throw new RepositoryException("Entity search failed!", e);
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        try {
            T dbEntity = entityManager.find(clazz, id);
            if (dbEntity == null) {
                return false;
            }

            entityManager.remove(dbEntity);
        } catch (PersistenceException e) {
            LOG.error("Entity delete failed!", e);
            return false;
        }
        return true;
    }

    @Override
    public T update(T entity) {
        try {
            entity = entityManager.merge(entity);
            entityManager.flush();
            return entity;
        } catch (PersistenceException e) {
            LOG.error("Entity update failed!", e);
            throw new RepositoryException("Entity update failed!", e);
        }
    }

    @Override
    public List<T> getAll() {
        //Criteria Query hasznalataval
        try {
            final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            final CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
            final Root<T> rootEntry = criteriaQuery.from(clazz);
            final CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
            final TypedQuery<T> allQuery = entityManager.createQuery(all);
            return allQuery.getResultList();
        } catch (IllegalArgumentException | PersistenceException ex) {
            LOG.error("getAll method invocation failed", ex);
            throw new RepositoryException("getAll method invocation failed", ex);
        }
    }
}
