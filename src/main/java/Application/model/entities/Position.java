package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.Entity;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
public class Position extends AbstractEntity {
    private String name;

    public Position() {
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position(String name) {
        this.name = name;
    }

}
