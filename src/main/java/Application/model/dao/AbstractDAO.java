package Application.model.dao;

import Application.model.entities.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Created by Rushan on 30.03.2016.
 */
public abstract class AbstractDAO<T extends AbstractEntity> {
    protected abstract EntityManager getEntityManager();

    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

//    public void persist(T entity) {
//        getEntityManager().persist(entity);
//    }

//    public void merge(T entity) {
//        getEntityManager().merge(entity);
//    }

    public void remove(T entity) {
        if (entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public T saveOrUpdate(final T entity) { return getEntityManager().merge(entity); }

    public void remove(Object id) {
        T entity = (T) getEntityManager().find(entityClass, id);
        remove(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

//    public void refresh(T entity) {
//        getEntityManager().refresh(entity);
//    }

    public TypedQuery<T> namedQuery(String queryName) {
        return getEntityManager().createNamedQuery(queryName, entityClass);
    }

    public TypedQuery<T> query(String queryString) {
        return getEntityManager().createQuery(queryString, entityClass);
    }
}
