package Application.model.entities;

import javax.persistence.*;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "contract_status")
@NamedQueries({
        @NamedQuery(name = ContractStatus.QUERY_FIND_ALL, query = "SELECT d FROM ContractStatus d"),
})

public class ContractStatus extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "ContractStatus.findAll";

    private String name;

    public ContractStatus() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ContractStatus(String name) {
        this.name = name;
    }

}
