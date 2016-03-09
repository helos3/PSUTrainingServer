package Application.model;

import Application.utils.MysqlUtils;
import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram extends AbstractEntity {
    private String name;
    private String category;
    private ArrayList<CategoryFactory.Module> modules;
    private boolean modulesUpdated = false;

    public TrainingProgram(String name, String category, ArrayList<CategoryFactory.Module> modules) {
        this.name = name;
        this.category = category;
        this.modules = modules;
    }

    public TrainingProgram(String name, String category) {
        this.name = name;
        this.category = category;
        this.modules = new ArrayList<>();
    }

    public TrainingProgram() {
        modules = new ArrayList<>();
    }

    public void addModule(CategoryFactory.Module module) {
        modules.add(module);
    }

    public void deleteModule(int index) {
        modules.remove(index);
    }

    public void setModules(ArrayList<CategoryFactory.Module> modules) {
        this.modules = modules;
    }

    public ArrayList<CategoryFactory.Module> getModules() {

        return modules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject() {{
            put("id", ID);
            put("name", name);
            put("category", category);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        name = (String) inputJSON.get("name");
        category = (String) inputJSON.get("category");
    }

    @Override
    public String toInsertQuery() {
        String insertQuery = "INSERT INTO mydb.training_program\n" +
                "(name,\n" +
                "category)\n" +
                "VALUES\n" +
                "(\"" + name + "\", \"" + category + "\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE mydb.training_program\n" +
                "SET\n" +
                "name = \"" + name + "\",\n" +
                "category = \"" + category + "\"\n" +
                "WHERE id = " + ID + ";\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM mydb.training_program\n" +
                "WHERE id = " + ID + ";\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "SELECT training_program.id,\n" +
                "    training_program.name,\n" +
                "    training_program.category\n" +
                "FROM mydb.training_program\n" +
                "WHERE id = " + ID + ";\n";
        return selectQuery;
    }


    public static TrainingProgram fromSelectQuery(ResultSet resultSet) throws SQLException {
        TrainingProgram program = new TrainingProgram();
        program.setID(resultSet.getInt("id"));
        program.setCategory(resultSet.getString("category"));
        program.setName(resultSet.getString("name"));
        return program;
    }

    public void getModulesFromDB(Connection connection) throws SQLException {
        String selectQuery = "SELECT training_plan.id,\n" +
                "    training_plan.training_program_id,\n" +
                "    training_plan.module_id,\n" +
                "    module.name\n" +
                "FROM mydb.training_plan, mydb.training_program, mydb.module\n" +
                "WHERE training_plan.training_program_id = 1 \n" +
                "\tand module.id = training_plan.module_id\n" +
                "GROUP BY training_plan.id;";
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, selectQuery);
        modules.clear();
        while (rs.next()) {
            CategoryFactory.Module module = new CategoryFactory().moduleCreate();
            module.setID(rs.getInt("training_plan.module_id"));
            module.setName(rs.getString("module.name"));
            modules.add(module);
        }
        modulesUpdated = true;
    }

    public void updateModulesAtDB(Connection connection) throws SQLException {
        if (!modulesUpdated) return;
        String updateQuery = "DELETE FROM mydb.training_plan\n" +
                "WHERE training_plan.training_program_id = " + ID + ";\n";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.executeUpdate();
        for (CategoryFactory.Module module : modules) {
            updateQuery = "INSERT INTO mydb.training_plan\n" +
                    "(training_program_id, module_id)\n" +
                    "VALUES \n" +
                    "(" + ID + ", \n" +
                    module.getID() + ");\n";
            statement = connection.prepareStatement(updateQuery);
            statement.executeUpdate();
        }
    }

    public static ArrayList<TrainingProgram> getValuesFromDB(Connection connection)
            throws SQLException {
        ArrayList<TrainingProgram> values = new ArrayList<>();
        String selectQuery = "SELECT training_program.id,\n" +
                "    training_program.name,\n" +
                "    training_program.category\n" +
                "FROM mydb.training_program;\n";
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, selectQuery);
        while (rs.next()) {
            TrainingProgram program = TrainingProgram.fromSelectQuery(rs);
            program.getModulesFromDB(connection);
            values.add(program);
        }
        return values;
    }

}
