package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Contract extends AbstractEntity {

    private Date signDate;
    private Listener listener;
    private String contractStatus;
    private TrainingProgram trainingProgram;

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public TrainingProgram getTrainingProgram() {

        return trainingProgram;
    }

    public Contract(int contractNumber, Date signDate, Listener listener) {
        this.signDate = signDate;
        this.listener = listener;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {

    }

    @Override
    public String toInsertQuery() {
        return null;
    }

    @Override
    public String toUpdateQuery() {
        return null;
    }

    @Override
    public String toDeleteQuery() {
        return null;
    }

    @Override
    public String toSelectQuery() {
        return null;
    }

    @Override
    public ResultSet fromSelectQuery() {
        return null;
    }

    public Date getSignDate() {
        return signDate;
    }

    public Listener getListener() {
        return listener;
    }

    public String getContractStatus() {
        return contractStatus;
    }
}
