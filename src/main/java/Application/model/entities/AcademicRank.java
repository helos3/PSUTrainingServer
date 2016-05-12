package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_rank")
@NamedQueries({
        @NamedQuery(name = AcademicRank.QUERY_FIND_ALL, query = "SELECT d FROM AcademicRank d"),
})

public class AcademicRank extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicRank.findAll";

    @NotNull
    private String name;

    public AcademicRank() {
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject(){{
            put("id", getId());
            put("name", getName());
        }};
    }

    public static AcademicRank instanceFromJSON(JSONObject object) {
        return new AcademicRank() {{
            setId((int) object.get("id"));
            setName((String) object.get("name"));
        }};
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AcademicRank(String name) {
        this.name = name;
    }
}
