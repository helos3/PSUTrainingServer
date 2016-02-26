package UnitTests.model;

import Application.model.CategoryFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 18.02.2016.
 */
public class BaseCategoryEntityTest {

    @Test
    public void testValues() throws SQLException{
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }


        CategoryFactory factory = new CategoryFactory();
        ArrayList<CategoryFactory.AcademicDegree> degrees =
                factory.academicDegreeCreate().convert(
                        factory.academicDegreeCreate().getValuesFromDB(connection));
        for (CategoryFactory.AcademicDegree degree: degrees)
            System.out.println(degree.toJSON().toString());

        ArrayList<CategoryFactory.AcademicRank> ranks =
                factory.academicRankCreate().convert(
                        factory.academicRankCreate().getValuesFromDB(connection));
        for (CategoryFactory.AcademicRank rank: ranks)
            System.out.println(rank.toJSON().toString());
    }
}