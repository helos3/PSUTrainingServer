package UnitTests.model;

import Application.model.CategoryFactory;
import Application.model.Contract;
import Application.model.Graduate;
import Application.model.ListenerProfessionalDataSet;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 17.02.2016.
 */
public class GraduateTest {

    @Test
    public void testFromSelectQuery() throws Exception {
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = new java.sql.Date(calendar.getTimeInMillis());
        int contractID = 3;
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

        Graduate graduate1 = new Graduate(contractID, dataSet, date);
        Graduate graduate2 = new Graduate();
//        System.out.println(graduate1.toJSON());
        graduate2.fromJSON(graduate1.toJSON());
//        System.out.println(graduate2.toJSON());
        Contract contract = new Contract();
        contract.setID(5);
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }
        contract.getGraduateFromDB(connection);
        System.out.println(contract.getGraduate().toJSON());
    }

    @Test
    public void testQueries(){
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = new java.sql.Date(calendar.getTimeInMillis());
        int contractID = 5;
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

        Graduate graduate1 = new Graduate(contractID, dataSet, date);

        System.out.println(graduate1.toInsertQuery());
        System.out.println(graduate1.toUpdateQuery());
        System.out.println(graduate1.toDeleteQuery());
        System.out.println(graduate1.toSelectQuery());
    }
}