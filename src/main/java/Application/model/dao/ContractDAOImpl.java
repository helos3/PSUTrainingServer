package Application.model.dao;

import Application.model.entities.AbstractEntity;
import Application.model.entities.AcademicRank;
import Application.model.entities.Contract;
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
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Contract> getAll() {
        return namedQuery(Contract.QUERY_FIND_ALL).getResultList();
    }

}
