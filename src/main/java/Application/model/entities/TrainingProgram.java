package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "training_program")
public class TrainingProgram extends AbstractEntity {

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
