package Application.model;

import Application.utils.AbstractEntity;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rushan on 12.02.2016.
 */
public class BaseCategoryEntity extends AbstractEntity {
    private String name, tableName;

    public BaseCategoryEntity(String tableName) {
        this.tableName = tableName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject() {{
            put("id", ID);
            put("name", name);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        name = (String) inputJSON.get("name");
    }

    @Override
    public String toInsertQuery() {
        String insertQuery =
                "INSERT INTO mydb." + tableName + "(name)\n" +
                        "VALUES (\"" + name + "\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {

        String updateQuery = "";
        if (!idIsNull()) updateQuery = "UPDATE mydb." + tableName + "\n" +
                "SET\n" +
                "name = " + name + " \n" +
                "WHERE id =" + ID + " ;\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "";
        if (!idIsNull()) deleteQuery = "DELETE FROM mydb." + tableName + "\n" +
                "WHERE id =" + ID + " ;\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "";
        if (!idIsNull()) selectQuery = "SELECT " + tableName + ".id,\n" +
                "    academic_rank.name\n" +
                "FROM mydb.academic_rank\n" +
                "WHERE id =" + ID + " ;\n";
        return selectQuery;
    }

    public void fromSelectQuery(ResultSet resultSet) throws SQLException {
        ID = resultSet.getInt("id");
        name = resultSet.getString("name");
    }


}
