package Application.model.entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Contract.QUERY_FIND_ALL, query = "SELECT d FROM Contract d"),
        @NamedQuery(name = Contract.QUERY_FIND_BY_ID, query = "SELECT d FROM Contract d WHERE id = :id")
})
public class Contract extends AbstractEntity implements Serializable{

    @Transient
    private static final long serialVersionUID = 1L;

    @Transient
    public static final String QUERY_FIND_ALL = "Contract.findAll";
    @Transient
    public static final String QUERY_FIND_BY_ID = "Contract.findByID";


    @ManyToOne
    private Listener listener;

    @Temporal(TemporalType.DATE)
    @Column(name = "sign_date")
    private Date signDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "complete_date")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "training_program_id")
    private TrainingProgram trainingProgram;

    @OneToOne
    @JoinColumn(name = "contract_status_id")
    private ContractStatus contractStatus;

    @OneToOne
    @JoinColumn(name = "current_academic_rank")
    private AcademicRank currentAcademicRank;

    @OneToOne
    @JoinColumn(name = "current_academic_degree")
    private AcademicDegree currentAcademicDegree;

    @OneToOne
    @JoinColumn(name = "current_position")
    private Position currentPosition;

    @OneToOne
    @JoinColumn(name = "current_subdivision")
    private Subdivision currentSubdivision;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Listener getListener() {
        return listener;
    }

    public Date getSignDate() {
        return signDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setCurrentAcademicRank(AcademicRank currentAcademicRank) {
        this.currentAcademicRank = currentAcademicRank;
    }

    public void setCurrentAcademicDegree(AcademicDegree currentAcademicDegree) {
        this.currentAcademicDegree = currentAcademicDegree;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setCurrentSubdivision(Subdivision currentSubdivision) {
        this.currentSubdivision = currentSubdivision;
    }

    public AcademicRank getCurrentAcademicRank() {
        return currentAcademicRank;
    }

    public AcademicDegree getCurrentAcademicDegree() {
        return currentAcademicDegree;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Subdivision getCurrentSubdivision() {
        return currentSubdivision;
    }


    public Contract() {
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Contract that = (Contract) o;
//        try {
//            return (getId() == that.getId() || getListener().getId() == that.getListener().getId());
//        } catch ( NullPointerException e) {
//            return (getId() == that.getId());
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result += getId();
//        if (listener != null) result += listener.getId() << 16;
//        return result;
//    }


}