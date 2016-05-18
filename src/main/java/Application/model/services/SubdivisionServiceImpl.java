package Application.model.services;

import Application.model.dao.ContractStatusDAOImpl;
import Application.model.dao.SubdivisionDAOImpl;
import Application.model.entities.ContractStatus;
import Application.model.entities.Subdivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class SubdivisionServiceImpl implements AbstractService<Subdivision> {

    @Autowired
    SubdivisionDAOImpl dao;

    @Override
    public List<Subdivision> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(Subdivision entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(Subdivision entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public Subdivision find(int id) {
        return dao.find(id);
    }

}
