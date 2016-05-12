package Application.model.services;

import Application.model.entities.AbstractEntity;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
public interface AbstractService<T extends AbstractEntity> {
    List<T> getAll();

    void saveOrUpdate(T entity);

    void remove(T entity);

    void remove(int id);
}
