package Application.model.services;

import Application.model.dao.AcademicDegreeDAOImpl;
import Application.model.entities.AcademicDegree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Service
public class AcademicDegreeServiceImpl implements AbstractService<AcademicDegree> {

    @Autowired
    AcademicDegreeDAOImpl academicDegreeDAO;

    @Override
    public List getAll() {
        return academicDegreeDAO.getAll();
    }

    @Override
    @Transactional
    public void saveOrUpdate(AcademicDegree entity) {
        academicDegreeDAO.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void remove(AcademicDegree entity) {
        academicDegreeDAO.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        academicDegreeDAO.remove(id);
    }
}
