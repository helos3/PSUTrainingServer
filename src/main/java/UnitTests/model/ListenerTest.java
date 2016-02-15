package UnitTests.model;

import Application.model.CategoryFactory;
import Application.model.Listener;
import Application.model.ListenerProfessionalDataSet;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class ListenerTest {

    @Test
    public void testQueries() throws Exception {
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
        Listener listener = new Listener("first_name", "second_name", "patronymic", "1111", "111111", "city1", dataSet);

        System.out.println(listener.toInsertQuery() + "\n");
        System.out.println(listener.toUpdateQuery() + "\n");
        System.out.println(listener.toDeleteQuery() + "\n");
        System.out.println(listener.toSelectQuery() + "\n");
    }


    @Test
    public void testToJSON() throws Exception {
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

        Listener listener = new Listener("first_name", "second_name", "patronymic", "pass_serial", "pass_number", "pass_serial", dataSet);
        System.out.println(listener.toJSON().toString());

    }

    @Test
    public void testFromJSON() throws Exception {
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

        Listener listener = new Listener("first_name", "second_name", "patronymic", "pass_serial", "pass_number", "pass_serial", dataSet);
        Listener listener1 = new Listener();
        listener1.fromJSON(listener.toJSON());
        System.out.println(listener1.toJSON().toString());

    }


}