package model;

import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Contract {
    private int contractNumber;
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
        this.contractNumber = contractNumber;
        this.signDate = signDate;
        this.listener = listener;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
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

    public int getContractNumber() {

        return contractNumber;
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
