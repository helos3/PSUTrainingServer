package Application.model.services;

import Application.model.dao.ContractStatusDAOImpl;
import Application.model.dao.PositionDAOImpl;
import Application.model.entities.ContractStatus;
import Application.model.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class PositionServiceImpl implements AbstractService<Position>{

    @Autowired
    PositionDAOImpl dao;

    @Override
    public List<Position> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(Position entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(Position entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public Position find(int id) {
        return dao.find(id);
    }

}
