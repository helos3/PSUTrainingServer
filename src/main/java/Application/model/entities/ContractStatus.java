package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table(name = "contract_status")
@NamedQueries({
        @NamedQuery(name = ContractStatus.QUERY_FIND_ALL, query = "SELECT d FROM ContractStatus d"),
        @NamedQuery(name = ContractStatus.QUERY_FIND_BY_ID, query = "SELECT d FROM ContractStatus d WHERE id = :id")
})

public class ContractStatus extends AbstractEntity implements Serializable{

    @Transient
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String QUERY_FIND_ALL = "ContractStatus.findAll";
    @Transient
    public static final String QUERY_FIND_BY_ID = "ContractStatus.findByID";

    private String name;

    public ContractStatus() {
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

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
