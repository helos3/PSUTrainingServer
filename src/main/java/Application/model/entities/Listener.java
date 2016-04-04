package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
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
public class Listener extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "Listener.findAll";
    @Transient
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

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "listener_id")
    private List<Contract> contracts;

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {

        return contracts;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    public void setAcademicRank(AcademicRank academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public AcademicRank getAcademicRank() {

        return academicRank;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public Position getPosition() {
        return position;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public Listener() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassSerial(String passSerial) {
        this.passSerial = passSerial;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassSerial() {
        return passSerial;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getCity() {
        return city;
    }


}
