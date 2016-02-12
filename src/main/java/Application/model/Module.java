package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;

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
        return null;
    }

    @Override
    public String toDeleteQuery() {
        return null;
    }

    @Override
    public String toSelectQuery() {
        return null;
    }

    @Override
    public ResultSet fromSelectQuery() {
        return null;
    }
}
