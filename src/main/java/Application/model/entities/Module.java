package Application.model.entities;

import com.fasterxml.jackson.annotation.*;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Module.QUERY_FIND_ALL, query = "SELECT d FROM Module d"),
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Module.class)

public class Module extends AbstractEntity{

    @Transient @JsonIgnore
    public static final String QUERY_FIND_ALL = "Module.findAll";

    private String name;

    public Module() {
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject(){{
            put("id", getId());
            put("name", getName());
        }};
    }

    public static Module instanceFromJSON(JSONObject object) {
        return new Module() {{
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

    public Module(String name) {
        this.name = name;
    }

//    @JsonBackReference(value="modules-ref")
//    @ManyToMany(cascade= CascadeType.ALL, mappedBy="modules", fetch = FetchType.EAGER)
//    Set<TrainingProgram> program;
//
//    @JsonBackReference(value="modules-ref")
//    public void setProgram(Set<TrainingProgram> program) {
//        this.program = program;
//    }
//
//    @JsonBackReference(value="modules-ref")
//    public Set<TrainingProgram> getProgram() {
//        return program;
//    }
}
