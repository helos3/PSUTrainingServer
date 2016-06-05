package Application.model.entities;

import javafx.geometry.Pos;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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


    @Override
    public Position cloneWithNoId() {
        Position clonedEntity = new Position();
        clonedEntity.setName(getName());
        return clonedEntity;
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
