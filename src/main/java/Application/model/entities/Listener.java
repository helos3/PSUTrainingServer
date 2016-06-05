package Application.model.entities;

import com.fasterxml.jackson.annotation.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = Listener.QUERY_FIND_ALL, query = "SELECT d FROM Listener d"),
        @NamedQuery(name = Listener.QUERY_FIND_BY_NAME, query = "SELECT d FROM Listener d WHERE first_name = :firstName " +
                "AND second_name = :secondName")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Listener.class)
@JsonRootName("listener")
public class Listener extends AbstractEntity {

    @Transient
    @JsonIgnore
    public static final String QUERY_FIND_ALL = "Listener.findAll";
    @Transient
    @JsonIgnore
    public static final String QUERY_FIND_BY_NAME = "Listener.findByName";


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    private String patronymic;
    @Column(name = "pass_serial")
    private String passSerial;
    @Column(name = "pass_number")
    private String passNumber;
    private String city;

    @OneToOne
    @JoinColumn(name = "academic_rank_id")
    private AcademicRank academicRank;

    @OneToOne
    @JoinColumn(name = "academic_degree_id")
    private AcademicDegree academicDegree;

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne
    @JoinColumn(name = "subdivision_id")
    private Subdivision subdivision;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "listener_id")
    @JsonManagedReference
    private List<Contract> contracts;

    public void deleteContract(Contract contract) {
        contract.setListener(null);
        contracts.remove(contract);
    }


    @JsonManagedReference
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @JsonManagedReference
    public List<Contract> getContracts() {
        return contracts;
    }

    public void addContract(Contract contract) {
        if (contracts == null)
            contracts = new ArrayList<>();
        contracts.add(contract);
    }



    @JsonProperty("academic_rank")
    public void setAcademicRank(AcademicRank academicRank) {
        this.academicRank = academicRank;
    }
    @JsonProperty("academic_degree")
    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }
    @JsonProperty("position")
    public void setPosition(Position position) {
        this.position = position;
    }
    @JsonProperty("subdivision")
    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    @JsonProperty("academic_rank")
    public AcademicRank getAcademicRank() {
        return academicRank;
    }
    @JsonProperty("academic_degree")
    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }
    @JsonProperty("position")
    public Position getPosition() {
        return position;
    }
    @JsonProperty("subdivision")
    public Subdivision getSubdivision() {
        return subdivision;
    }

    public Listener() {
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty("second_name")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    @JsonProperty("patronymic")
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    @JsonProperty("pass_serial")
    public void setPassSerial(String passSerial) {
        this.passSerial = passSerial;
    }
    @JsonProperty("pass_number")
    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }
    @JsonProperty("second_name")
    public String getSecondName() {
        return secondName;
    }
    @JsonProperty("patronymic")
    public String getPatronymic() {
        return patronymic;
    }
    @JsonProperty("pass_serial")
    public String getPassSerial() {
        return passSerial;
    }
    @JsonProperty("pass_number")
    public String getPassNumber() {
        return passNumber;
    }
    @JsonProperty("city")
    public String getCity() {
        return city;
    }


    @Override
    public Listener cloneWithNoId() {
        Listener clonedEntity = new Listener();
        clonedEntity.setFirstName(getFirstName());
        clonedEntity.setSecondName(getSecondName());
        clonedEntity.setPatronymic(getPatronymic());
        clonedEntity.setCity(getCity());
        clonedEntity.setPassNumber(getPassNumber());
        clonedEntity.setPassSerial(getPassSerial());
        clonedEntity.setAcademicDegree(getAcademicDegree());
        clonedEntity.setAcademicRank(getAcademicRank());
        clonedEntity.setPosition(getPosition());
        clonedEntity.setSubdivision(getSubdivision());
        clonedEntity.setContracts(getContracts());
        return clonedEntity;
    }


}
