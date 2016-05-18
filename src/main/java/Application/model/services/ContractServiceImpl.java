package Application.model.services;

import Application.model.dao.AcademicDegreeDAOImpl;
import Application.model.dao.ContractDAOImpl;
import Application.model.entities.AcademicDegree;
import Application.model.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class ContractServiceImpl implements AbstractService<Contract> {
    @Autowired
    ContractDAOImpl dao;

    @Override
    public List<Contract> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(Contract entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(Contract entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public Contract find(int id) {
        return dao.find(id);
    }


}
