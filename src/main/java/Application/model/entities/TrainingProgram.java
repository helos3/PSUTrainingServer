package Application.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
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
    private List<Module> modules;

    public TrainingProgram() {
    }

    public void addModule(Module module) {
        if (modules == null)
            modules = new ArrayList<>();
        modules.add(module);
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


}
