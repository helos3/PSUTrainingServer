package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram extends AbstractEntity{
    private String name, cathegory;
    private HashMap<Integer, Module> modules; //key - id, value - name


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

    @Override
    public ResultSet fromSelectQuery() {
        return null;
    }

    public TrainingProgram(int ID, String name, String cathegory) {
        this.ID = ID;
        this.name = name;
        this.cathegory = cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public String getName() {

        return name;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setModules(HashMap<Integer, Module> modules) {
        this.modules = modules;
    }

    public HashMap<Integer, Module> getModules() {
        return modules;
    }

}
