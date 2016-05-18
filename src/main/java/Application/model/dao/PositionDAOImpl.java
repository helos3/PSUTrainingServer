package Application.model.dao;

import Application.model.entities.AcademicRank;
import Application.model.entities.Position;
import org.springframework.stereotype.Repository;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class PositionDAOImpl extends AbstractDAO<Position> {
    @PersistenceContext(name = "position")
    private EntityManager entityManager;

    public PositionDAOImpl() {
        super(Position.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Position> getAll() {
        return namedQuery(Position.QUERY_FIND_ALL).getResultList();
    }

}
