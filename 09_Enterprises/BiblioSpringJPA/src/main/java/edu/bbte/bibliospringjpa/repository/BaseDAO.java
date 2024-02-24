package edu.bbte.bibliospringjpa.repository;

import edu.bbte.bibliospringjpa.model.AbstractModel;

import java.util.List;

public interface BaseDAO<T extends AbstractModel, I> {
    public T create(T entity);

    public T getById(I id);

    public boolean deleteByID(Long id);

    public T update(T entity);

    public List<T> getAll();


}
