package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram extends AbstractEntity {
    private String name;
    private String category;

    public TrainingProgram(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public TrainingProgram() {
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
        return new JSONObject(){{
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
        String insertQuery = "INSERT INTO `mydb`.`training_program`\n" +
                "(`name`,\n" +
                "`category`)\n" +
                "VALUES\n" +
                "(\"" + name + "\", \"" + category + "\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE `mydb`.`training_program`\n" +
                "SET\n" +
                "`name` = \"" + name + "\",\n" +
                "`category` = \"" + category + "\"\n" +
                "WHERE `id` = " + ID + ";\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM `mydb`.`training_program`\n" +
                "WHERE `id` = " + ID + ";\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "SELECT `training_program`.`id`,\n" +
                "    `training_program`.`name`,\n" +
                "    `training_program`.`category`\n" +
                "FROM `mydb`.`training_program`\n" +
                "WHERE `id` = " + ID + ";\n";
        return selectQuery;
    }

    @Override
    public void fromSelectQuery(ResultSet resultSet) throws SQLException {
        ID = resultSet.getInt("id");
        category = resultSet.getString("category");
        name = resultSet.getString("name");
    }

}
