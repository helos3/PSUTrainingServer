package Application.model.dao;

import Application.model.entities.AcademicRank;
import Application.model.entities.ContractStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Repository
public class ContractStatusDAOImpl extends AbstractDAO<ContractStatus> {
    @PersistenceContext(name = "contract_status")
    private EntityManager entityManager;

    public ContractStatusDAOImpl() {
        super(ContractStatus.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<ContractStatus> getAll() {
        return namedQuery(ContractStatus.QUERY_FIND_ALL).getResultList();
    }

}
