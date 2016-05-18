package Application.model.services;

import Application.model.dao.AcademicRankDAOImpl;
import Application.model.dao.ContractDAOImpl;
import Application.model.dao.ContractStatusDAOImpl;
import Application.model.entities.AcademicRank;
import Application.model.entities.ContractStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class ContractStatusServiceImpl implements AbstractService<ContractStatus> {

    @Autowired
    ContractStatusDAOImpl dao;

    @Override
    public List<ContractStatus> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(ContractStatus entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(ContractStatus entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public ContractStatus find(int id) {
        return dao.find(id);
    }


}
