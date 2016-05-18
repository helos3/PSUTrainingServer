package Application.model.services;

import Application.model.dao.ContractStatusDAOImpl;
import Application.model.dao.ListenerDAOImpl;
import Application.model.entities.ContractStatus;
import Application.model.entities.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class ListenerServiceImpl implements AbstractService<Listener> {

    @Autowired
    ListenerDAOImpl dao;

    @Override
    public List<Listener> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(Listener entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(Listener entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public Listener find(int id) {
        return dao.find(id);
    }

}
