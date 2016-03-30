package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_degree")
@NamedQueries({
        @NamedQuery(name = AcademicDegree.QUERY_FIND_ALL, query = "SELECT d FROM AcademicDegree d"),
        @NamedQuery(name = AcademicDegree.QUERY_FIND_BY_ID, query = "SELECT d FROM AcademicDegree d WHERE id = :id")
})
public class AcademicDegree extends AbstractEntity implements Serializable {
    private String name;

    @Transient
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicDegree.findAll";
    @Transient
    public static final String QUERY_FIND_BY_ID = "AcademicDegree.findByID";

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
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }



}
