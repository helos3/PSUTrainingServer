package Application.model.services;

import Application.model.dao.AcademicRankDAOImpl;
import Application.model.entities.AcademicDegree;
import Application.model.entities.AcademicRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@Component
public class AcademicRankServiceImpl implements AbstractService<AcademicRank> {

    @Autowired
    AcademicRankDAOImpl dao;

    @Override
    public List<AcademicRank> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public int saveOrUpdate(AcademicRank entity) {
        return dao.saveOrUpdate(entity).getId();
    }

    @Override
    @Transactional
    public void remove(AcademicRank entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional
    public void remove(int id) {
        dao.remove(id);
    }

    @Override
    public AcademicRank find(int id) {
        return dao.find(id);
    }


}
