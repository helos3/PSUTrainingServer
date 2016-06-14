package Application.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Position.QUERY_FIND_ALL, query = "SELECT d FROM Position d"),
})

public class Position extends AbstractEntity{

    @Transient
    public static final String QUERY_FIND_ALL = "Position.findAll";

    @NotNull
    private String name;

    public Position() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position(String name) {
        this.name = name;
    }

}
