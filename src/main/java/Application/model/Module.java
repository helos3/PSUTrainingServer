package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Module extends AbstractEntity {
    String name;

    public Module() {
    }

    public Module(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("name", name);
        if (!idIsNull()) resultJSON.put("id", ID);
        return resultJSON;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        if ((boolean) inputJSON.get("idParam"))
            ID = (int) inputJSON.get("id");
        name = (String) inputJSON.get("name");
    }

    @Override
    public String toInsertQuery() {
        String insertQuery =
        "INSERT INTO `mydb`.`module`(`name`)\n" +
                "VALUES (\""+name+"\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {

        String updateQuery = "";
        if (!idIsNull()) updateQuery = "UPDATE `mydb`.`module`\n" +
                        "SET\n" +
                        "`name` = "+ name +" \n" +
                        "WHERE `id` ="+ ID +" ;\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "";
        if (!idIsNull()) deleteQuery = "DELETE FROM `mydb`.`module`\n" +
                "WHERE `id` ="+ ID +" ;\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "";
        if (!idIsNull()) selectQuery = "SELECT `module`.`id`,\n" +
                "    `module`.`name`\n" +
                "FROM `mydb`.`module`\n" +
                "WHERE `id` ="+ ID +" ;\n";
        return selectQuery;
    }

    @Override
    public void fromSelectQuery(ResultSet resultSet) throws SQLException{
        ID = resultSet.getInt("id");
        name = resultSet.getString("name");
    }
}
