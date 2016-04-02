package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_rank")
@NamedQueries({
        @NamedQuery(name = AcademicRank.QUERY_FIND_ALL, query = "SELECT d FROM AcademicRank d"),
})

public class AcademicRank extends AbstractEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicRank.findAll";

    private String name;

    public AcademicRank() {
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

    public AcademicRank(String name) {
        this.name = name;
    }
}
