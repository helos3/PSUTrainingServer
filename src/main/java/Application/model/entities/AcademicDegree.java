package Application.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_degree")
@NamedQueries({
        @NamedQuery(name = AcademicDegree.QUERY_FIND_ALL, query = "SELECT d FROM AcademicDegree d"),
})
public class AcademicDegree extends AbstractEntity {

    @NotNull
    private String name;

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicDegree.findAll";

    public AcademicDegree() {
    }




    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AcademicDegree(String name) {
        this.name = name;
    }

    public String toString() {
        return "AcademicDegree{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }

}
