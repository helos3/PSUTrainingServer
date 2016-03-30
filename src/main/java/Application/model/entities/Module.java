package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.Entity;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
public class Module extends AbstractEntity {
    private String name;

    public Module() {
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Module(String name) {
        this.name = name;
    }



}
