package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram extends AbstractEntity{
    private String name, category;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    @Override
    public String toInsertQuery() {
        return null;
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


    public TrainingProgram(int ID, String name, String cathegory) {
        this.ID = ID;
        this.name = name;
        this.category = cathegory;
    }

    public void setCategory(String cathegory) {
        this.category = cathegory;
    }

    public String getName() {

        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void fromSelectQuery(ResultSet resultSet) throws SQLException {

    }
}
