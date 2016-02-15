package UnitTests.model;

import Application.model.CategoryFactory;
import Application.model.CompletedTraining;
import Application.model.Listener;
import Application.model.ListenerProfessionalDataSet;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class CompletedTrainingTest {

    @Test
    public void testToJSON() throws Exception {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank1 = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree1 = factory.academicDegreeCreate();
        CategoryFactory.Position position1 = factory.positionCreate();
        CategoryFactory.Subdivision subdivision1 = factory.subdivisionCreate();
        academicDegree1.setID(1);
        academicDegree1.setName("name1");
        academicRank1.setID(1);
        academicRank1.setName("name1");
        position1.setID(1);
        position1.setName("name1");
        subdivision1.setID(1);
        subdivision1.setName("name1");
        ListenerProfessionalDataSet dataSet1 = new ListenerProfessionalDataSet(subdivision1, position1, academicDegree1, academicRank1);
        Listener listener = new Listener("first_name", "second_name", "patronymic", "pass_serial", "pass_number", "pass_serial", dataSet1);

        CategoryFactory.AcademicRank academicRank2 = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree2 = factory.academicDegreeCreate();
        CategoryFactory.Position position2 = factory.positionCreate();
        CategoryFactory.Subdivision subdivision2 = factory.subdivisionCreate();
        academicDegree2.setID(1);
        academicDegree2.setName("name");
        academicRank2.setID(1);
        academicRank2.setName("name2");
        position2.setID(1);
        position2.setName("name2");
        subdivision2.setID(1);
        subdivision2.setName("name2");
        ListenerProfessionalDataSet dataSet2 = new ListenerProfessionalDataSet(subdivision2, position2, academicDegree2, academicRank2);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTimeInMillis());
        CompletedTraining trainedOne = new CompletedTraining(listener, dataSet2, date);
        CompletedTraining trainedOne2 = new CompletedTraining();
        System.out.println(trainedOne.toJSON());
        trainedOne2.fromJSON(trainedOne.toJSON());
        System.out.println(trainedOne2.toJSON());

    }

    @Test
    public void testFromJSON() throws Exception {

    }
}