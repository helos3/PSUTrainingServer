package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "training_program")
@NamedQueries({
        @NamedQuery(name = TrainingProgram.QUERY_FIND_ALL, query = "SELECT d FROM TrainingProgram d"),
})
public class TrainingProgram extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "TrainingProgram.findAll";


    private String name;
    private String category;
    @ManyToMany
    @JoinTable(name = "training_plan",
            joinColumns = @JoinColumn(name = "training_program_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

    public TrainingProgram() {
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Module> getModules() {

        return modules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    @Override
    public JSONObject toJSON() {
        return null;
    }
}
