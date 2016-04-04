package Application.model.ejb;

import Application.model.entities.AcademicDegree;
import Application.model.entities.AcademicRank;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 04.04.2016.
 */

@Stateless
public class AcademicDegreeContainer extends AbstractEntityContainer<AcademicDegree> {
    @PersistenceContext(name = "academic_degree")
    private EntityManager entityManager;

    public AcademicDegreeContainer() {
        super(AcademicDegree.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AcademicDegree> findAll() {
        return namedQuery(AcademicDegree.QUERY_FIND_ALL).getResultList();
    }


}
