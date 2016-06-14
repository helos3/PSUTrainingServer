package Application.model.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

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


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Module(String name) {
        this.name = name;
    }

}
