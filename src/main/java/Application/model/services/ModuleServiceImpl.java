package Application.model.services;

import Application.model.dao.ContractStatusDAOImpl;
import Application.model.dao.ModuleDAOImpl;
import Application.model.entities.ContractStatus;
import Application.model.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class ModuleServiceImpl implements AbstractService<Module> {

    @Autowired
    ModuleDAOImpl dao;

    @Override
    public List<Module> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(Module entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(Module entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public Module find(int id) {
        return dao.find(id);
    }

}
