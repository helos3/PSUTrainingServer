package UnitTests.model;

import Application.model.CategoryFactory;
import Application.model.ListenerProfessionalDataSet;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class ListenerProfessionalDataSetTest {

    @Test
    public void testToJSON() throws Exception {
//        System.out.println(putData().toJSON().toString());
    }

    @Test
    public void fromJSON() throws Exception {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        academicDegree.setID(2);
        academicDegree.setName("name2");
        academicRank.setID(3);
        academicRank.setName("n1me1");
        position.setID(5);
        position.setName("na1e1");
        subdivision.setID(6);
        subdivision.setName("1ame1");
        ListenerProfessionalDataSet dataSet = putData();
        dataSet.setAcademicDegree(academicDegree);
        dataSet.setAcademicRank(academicRank);
        dataSet.setPosition(position);
        dataSet.setSubdivision(subdivision);
        System.out.println(dataSet.toJSON().toString());
        dataSet.fromJSON(putData().toJSON());
        System.out.println(dataSet.toJSON().toString());
    }

    public ListenerProfessionalDataSet putData() {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        academicDegree.setID(1);
        academicDegree.setName("name1");
        academicRank.setID(1);
        academicRank.setName("name1");
        position.setID(1);
        position.setName("name1");
        subdivision.setID(1);
        subdivision.setName("name1");
        ListenerProfessionalDataSet dataSet = new ListenerProfessionalDataSet(subdivision, position, academicDegree, academicRank);
        return dataSet;
    }
}