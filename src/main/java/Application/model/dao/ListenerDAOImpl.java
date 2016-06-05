package Application.model.dao;

import Application.model.entities.AcademicRank;
import Application.model.entities.Listener;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class ListenerDAOImpl extends AbstractDAO<Listener> {

    @PersistenceContext(name = "listener")
    private EntityManager entityManager;

    public ListenerDAOImpl() {
        super(Listener.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Listener> getAll() {
        return namedQuery(Listener.QUERY_FIND_ALL).getResultList();
    }

}
