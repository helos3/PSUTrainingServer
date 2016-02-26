package UnitTests.model;

import Application.model.CategoryFactory;
import Application.model.TrainingProgram;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class TrainingProgramTest {

//    @Test
    public void testToJSON() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toJSON().toString());
    }

//    @Test
    public void testFromJSON() throws Exception {
        TrainingProgram program1 = new TrainingProgram("name1", "category1");
        TrainingProgram program2 = new TrainingProgram("name2", "category2");
        program1.setID(1);
        program2.fromJSON(program1.toJSON());
        System.out.println(program1.toJSON().toString());
    }

//    @Test
    public void testToInsertQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toInsertQuery());
    }

//    @Test
    public void testToUpdateQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toUpdateQuery());
    }

//    @Test
    public void testToDeleteQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toDeleteQuery());
    }

//    @Test
    public void testToSelectQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toSelectQuery());
    }

    @Test
    public void testUpdateModulesAtDB() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }
        program.getModulesFromDB(connection);
        CategoryFactory.Module module = new CategoryFactory().moduleCreate();
        module.setID(2);
        program.addModule(module);
        program.updateModulesAtDB(connection);
    }

    @Test
    public void testGetValuesFromDB() throws Exception {
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }
        ArrayList<TrainingProgram> programs = TrainingProgram.getValuesFromDB(connection);
        for (TrainingProgram program: programs) {
            System.out.println(program.toJSON().toString());
        }
    }
}