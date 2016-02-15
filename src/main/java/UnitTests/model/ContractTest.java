package UnitTests.model;

import Application.model.*;
import org.junit.Test;
import sun.util.calendar.CalendarDate;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class ContractTest {

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
        status.setName("name1");
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
        Contract contract = new Contract(program, status, listener, date);
//        System.out.println(contract.toJSON());
    }

    @Test
    public void testFromJSON() throws Exception {
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
        Contract contract1 = new Contract(program, status, listener, date);
        Contract contract2 = new Contract();
        contract2.fromJSON(contract1.toJSON());
        System.out.println(contract1.toJSON().toString());
        System.out.println(contract2.toJSON().toString());
    }
}