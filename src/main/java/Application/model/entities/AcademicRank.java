package Application.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "academic_rank")
@NamedQueries({
        @NamedQuery(name = AcademicRank.QUERY_FIND_ALL, query = "SELECT d FROM AcademicRank d"),
})

public class AcademicRank extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "AcademicRank.findAll";

    @NotNull
    private String name;

    public AcademicRank() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AcademicRank(String name) {
        this.name = name;
    }
}
