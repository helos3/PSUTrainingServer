package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.Entity;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
public class Subdivision extends AbstractEntity {
    private String name;

    public Subdivision() {
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

    public Subdivision(String name) {
        this.name = name;
    }

}
