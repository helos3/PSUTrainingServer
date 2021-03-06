package Application.model.services;

import Application.model.dao.AcademicDegreeDAOImpl;
import Application.model.entities.AcademicDegree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class AcademicDegreeServiceImpl implements AbstractService<AcademicDegree> {

    @Autowired
    AcademicDegreeDAOImpl dao;

    @Override
    public List<AcademicDegree> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(AcademicDegree entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(AcademicDegree entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public AcademicDegree find(int id) {
        return dao.find(id);
    }
}
