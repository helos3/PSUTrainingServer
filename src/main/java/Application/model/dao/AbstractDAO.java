package Application.model.dao;

import Application.model.entities.AbstractEntity;
import Application.model.entities.Contract;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rushan on 30.03.2016.
 */
public abstract class AbstractDAO<T extends AbstractEntity> {

    protected abstract EntityManager getEntityManager();
    public abstract List<T> getAll();

    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void remove(T entity) {
        if (entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public T saveOrUpdate(final T entity) {
        T existingEntity = find(entity.getId());
        if (existingEntity == null) {
            AbstractEntity newEntity = entity.clone();
            newEntity.setId(null);
            getEntityManager().persist(newEntity);
            entity.setId(newEntity.getId());
            return entity;
        }
        else
        return getEntityManager().merge(entity);
    }

    public void remove(Object id) {
        T entity = (T) getEntityManager().find(entityClass, id);
        remove(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }


    public TypedQuery<T> namedQuery(String queryName) {
        return getEntityManager().createNamedQuery(queryName, entityClass);
    }

    public TypedQuery<T> query(String queryString) {
        return getEntityManager().createQuery(queryString, entityClass);
    }
}
