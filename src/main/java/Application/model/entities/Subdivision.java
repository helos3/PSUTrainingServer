package Application.model.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Subdivision.QUERY_FIND_ALL, query = "SELECT d FROM Subdivision d"),
})
public class Subdivision extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "Subdivision.findAll";

    private String name;

    public Subdivision() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Subdivision(String name) {
        this.name = name;
    }

}
