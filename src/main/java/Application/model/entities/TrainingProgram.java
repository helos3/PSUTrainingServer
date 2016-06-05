package Application.model.entities;

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
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
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
    public TrainingProgram cloneWithNoId() {
        TrainingProgram clonedEntity = new TrainingProgram();
        clonedEntity.setName(getName());
        clonedEntity.setCategory(getCategory());
        clonedEntity.setModules(getModules());
        return clonedEntity;
    }

}
