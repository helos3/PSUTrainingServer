package Application.model.dao;

import Application.model.entities.AcademicDegree;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 04.04.2016.
 */

@Repository
public class AcademicDegreeDAOImpl extends AbstractDAO<AcademicDegree> {
    @PersistenceContext(name = "academic_degree")
    private EntityManager entityManager;

    public AcademicDegreeDAOImpl() {
        super(AcademicDegree.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<AcademicDegree> getAll() {
        return namedQuery(AcademicDegree.QUERY_FIND_ALL).getResultList();
    }


}
