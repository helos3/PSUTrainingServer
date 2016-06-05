package Application.model.dao;

import Application.model.entities.AcademicRank;
import Application.model.entities.Module;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class ModuleDAOImpl extends AbstractDAO<Module> {
    @PersistenceContext(name = "module")
    private EntityManager entityManager;

    public ModuleDAOImpl() {
        super(Module.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Module> getAll() {
        return namedQuery(Module.QUERY_FIND_ALL).getResultList();
    }

}
