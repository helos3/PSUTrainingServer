package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Module.QUERY_FIND_ALL, query = "SELECT d FROM Module d"),
})
public class Module extends AbstractEntity{

    @Transient
    public static final String QUERY_FIND_ALL = "Module.findAll";

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
