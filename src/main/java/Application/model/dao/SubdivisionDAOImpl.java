package Application.model.dao;

import Application.model.entities.AcademicRank;
import Application.model.entities.Subdivision;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class SubdivisionDAOImpl extends AbstractDAO<Subdivision>{
    @PersistenceContext(name = "subdivision")
    private EntityManager entityManager;

    public SubdivisionDAOImpl() {
        super(Subdivision.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Subdivision> getAll() {
        return namedQuery(Subdivision.QUERY_FIND_ALL).getResultList();
    }

}
