package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_degree")
@NamedQueries({
        @NamedQuery(name = AcademicDegree.QUERY_FIND_ALL, query = "SELECT d FROM AcademicDegree d"),
})
public class AcademicDegree extends AbstractEntity {

    @NotNull
    private String name;

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicDegree.findAll";

    public AcademicDegree() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AcademicDegree(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject(){{
            put("id", getId());
            put("name", getName());
        }};
    }

    public static AcademicDegree instanceFromJSON(JSONObject object) {
        return new AcademicDegree() {{
            setId((int) object.get("id"));
            setName((String) object.get("name"));
        }};
    }



}
