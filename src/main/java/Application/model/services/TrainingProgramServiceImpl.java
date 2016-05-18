package Application.model.services;

import Application.model.dao.ContractStatusDAOImpl;
import Application.model.dao.TrainingProgramDAOImpl;
import Application.model.entities.AbstractEntity;
import Application.model.entities.ContractStatus;
import Application.model.entities.Subdivision;
import Application.model.entities.TrainingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class TrainingProgramServiceImpl implements AbstractService<TrainingProgram>{

    @Autowired
    TrainingProgramDAOImpl dao;

    @Override
    public List<TrainingProgram> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(TrainingProgram entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(TrainingProgram entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public TrainingProgram find(int id) {
        return dao.find(id);
    }

}
