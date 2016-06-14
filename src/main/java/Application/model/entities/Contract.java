package Application.model.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rushan on 23.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Contract.QUERY_FIND_ALL, query = "SELECT d FROM Contract d"),
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Contract.class)
public class Contract extends AbstractEntity {

    @Transient
    public static final String QUERY_FIND_ALL = "Contract.findAll";


//    @ManyToOne
//    @JoinColumn(name = "listener_id", referencedColumnName = "id")
//    private int listenerID;

    @ManyToOne
    @JoinColumn(name = "listener_id")
    Listener listener;

    @Temporal(TemporalType.DATE)
    @Column(name = "sign_date")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date signDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "complete_date")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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
    @JsonProperty("listener_id")
    public int getListenerID() {
        return listener.getId();
    }

    @JsonProperty("listener_id")
    public void setListenerID(int listenerID) {
        if (listener == null) listener = new Listener();
        listener.setId(listenerID);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @JsonBackReference
    public Listener getListener() {
        return listener;
    }

    @JsonProperty("sign_date")
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
    @JsonProperty("end_date")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @JsonProperty("training_program")
    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }
    @JsonProperty("contract_status")
    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
    @JsonProperty("sign_date")
    public Date getSignDate() {
        return signDate;
    }
    @JsonProperty("end_date")
    public Date getEndDate() {
        return endDate;
    }
    @JsonProperty("training_program")
    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }
    @JsonProperty("contract_status")
    public ContractStatus getContractStatus() {
        return contractStatus;
    }
    @JsonProperty("current_academic_rank")
    public void setCurrentAcademicRank(AcademicRank currentAcademicRank) {
        this.currentAcademicRank = currentAcademicRank;
    }
    @JsonProperty("current_academic_degree")
    public void setCurrentAcademicDegree(AcademicDegree currentAcademicDegree) {
        this.currentAcademicDegree = currentAcademicDegree;
    }
    @JsonProperty("current_position")
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    @JsonProperty("current_subdivision")
    public void setCurrentSubdivision(Subdivision currentSubdivision) {
        this.currentSubdivision = currentSubdivision;
    }
    @JsonProperty("current_academic_rank")
    public AcademicRank getCurrentAcademicRank() {
        return currentAcademicRank;
    }
    @JsonProperty("current_academic_degree")
    public AcademicDegree getCurrentAcademicDegree() {
        return currentAcademicDegree;
    }
    @JsonProperty("current_position")
    public Position getCurrentPosition() {
        return currentPosition;
    }
    @JsonProperty("current_subdivision")
    public Subdivision getCurrentSubdivision() {
        return currentSubdivision;
    }


    public Contract() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contract that = (Contract) o;
        try {
            return (getId() == that.getId() || getListener().getId() == that.getListener().getId());
//            return (getId() == that.getId() || getListenerID() == that.getListenerID());
        } catch (NullPointerException e) {
            return (getId() == that.getId());
        }
    }

    //
    @Override
    public int hashCode() {
        int result = 17;
        result += getId();
        if (listener != null) result += listener.getId() << 16;
        return result;
    }


}
