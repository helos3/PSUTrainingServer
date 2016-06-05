package Application.model.dao;

import Application.model.entities.AcademicDegree;
import Application.model.entities.AcademicRank;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class AcademicRankDAOImpl extends AbstractDAO<AcademicRank> {
    @PersistenceContext(name = "academic_rank")
    private EntityManager entityManager;

    public AcademicRankDAOImpl() {
        super(AcademicRank.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<AcademicRank> getAll() {
        return namedQuery(AcademicRank.QUERY_FIND_ALL).getResultList();
    }

}
