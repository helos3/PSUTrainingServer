package Application.model.dao;

import Application.model.entities.Subdivision;
import Application.model.entities.TrainingProgram;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class TrainingProgramDAOImpl extends AbstractDAO<TrainingProgram> {
    @PersistenceContext(name = "training_program")
    private EntityManager entityManager;

    public TrainingProgramDAOImpl() {
        super(TrainingProgram.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<TrainingProgram> getAll() {
        return namedQuery(TrainingProgram.QUERY_FIND_ALL).getResultList();
    }

}
