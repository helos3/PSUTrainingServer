package UnitTests.model;

import Application.model.*;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Rushan on 15.02.2016.
 */
public class CompletedTrainingTest {

    @Test
    public void testToJSON() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        CategoryFactory.ContractStatus status = factory.contractStatusCreate();
        status.setID(1);
        status.setName("it is not name even");
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
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTimeInMillis());

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
        Graduate trainedOne2 = new Graduate();

    }

    @Test
    public void testFromJSON() throws Exception {

    }
}