package Application.model.dao;

import Application.model.entities.AbstractEntity;
import Application.model.entities.AcademicRank;
import Application.model.entities.Contract;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class ContractDAOImpl extends AbstractDAO<Contract> {
    @PersistenceContext(name = "contract")
    private EntityManager entityManager;

    public ContractDAOImpl() {
        super(Contract.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Contract> getAll() {
        return namedQuery(Contract.QUERY_FIND_ALL).getResultList();
    }

    public void remove(Object id) {
        Contract entity = (Contract) getEntityManager().find(Contract.class, id);
        remove(entity);
    }


    @Override
    public void remove(Contract entity) {
//        entity.getListener().deleteContract(entity);
        super.remove(entity);
    }
}
