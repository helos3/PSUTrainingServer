package Application.model.entities;

import Application.utils.ManyToManyDeserialize;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "training_program")
@NamedQueries({
        @NamedQuery(name = TrainingProgram.QUERY_FIND_ALL, query = "SELECT d FROM TrainingProgram d"),
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = TrainingProgram.class)

public class TrainingProgram extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "TrainingProgram.findAll";


    private String name;
    private String category;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "training_plan",
            joinColumns = @JoinColumn(name = "training_program_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
//    @JsonManagedReference(value="modules-ref")
//    @JsonDeserialize(using = ManyToManyDeserialize.class)
    private List<Module> modules;

    public TrainingProgram() {
    }

    public void addModule(Module module) {
        if (modules == null)
            modules = new ArrayList<>();
        modules.add(module);
    }

//    @JsonManagedReference(value="modules-ref")
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

//    @JsonManagedReference(value="modules-ref")
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
    public JSONObject toJSON() {
        return new JSONObject() {{
            put("id", getId());
            put("name", getName());
            JSONArray modulesJSON = new JSONArray();
            for (Module module : getModules()) {
                modulesJSON.add(module.toJSON());
            }
            put("modules", modulesJSON.toJSONString());
        }};
    }

    public static TrainingProgram instanceFromJSON(JSONObject object) {
        return new TrainingProgram() {{
            setId((int) object.get("id"));
            setName((String) object.get("name"));
            JSONArray modulesJSON = (JSONArray) object.get("modules");
            Iterator i = modulesJSON.iterator();
            while (i.hasNext()) {
                JSONObject moduleJSON = (JSONObject) i.next();
                Module module = Module.instanceFromJSON(moduleJSON);
                addModule(module);
            }
        }};
    }
}
