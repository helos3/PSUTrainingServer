package UnitTests.model;

import Application.model.TrainingProgram;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 15.02.2016.
 */
public class TrainingProgramTest {

    @Test
    public void testToJSON() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toJSON().toString());
    }

    @Test
    public void testFromJSON() throws Exception {
        TrainingProgram program1 = new TrainingProgram("name1", "category1");
        TrainingProgram program2 = new TrainingProgram("name2", "category2");
        program1.setID(1);
        program2.fromJSON(program1.toJSON());
        System.out.println(program1.toJSON().toString());
    }

    @Test
    public void testToInsertQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toInsertQuery());
    }

    @Test
    public void testToUpdateQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toUpdateQuery());
    }

    @Test
    public void testToDeleteQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toDeleteQuery());
    }

    @Test
    public void testToSelectQuery() throws Exception {
        TrainingProgram program = new TrainingProgram("name", "category");
        program.setID(1);
        System.out.println(program.toSelectQuery());
    }
}