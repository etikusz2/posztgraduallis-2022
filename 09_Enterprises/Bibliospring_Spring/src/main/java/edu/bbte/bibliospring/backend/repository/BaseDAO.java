package edu.bbte.bibliospring.backend.repository;

import edu.bbte.bibliospring.backend.model.AbstractModel;

import java.util.List;

public interface BaseDAO<T extends AbstractModel, I> {
    T create(T entity) throws RepositoryException;
    void delete(I id) throws RepositoryException;
    T update(T entity) throws RepositoryException;
    T getByID(I id) throws RepositoryException;
    List<T> getAll() throws RepositoryException;
 }
