package model;

import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class CompletedTraining {
    private Listener listener;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;
    private Date endDate;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setListenerProfessionalDataSet(ListenerProfessionalDataSet listenerProfessionalDataSet) {
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Listener getListener() {

        return listener;
    }

    public ListenerProfessionalDataSet getListenerProfessionalDataSet() {
        return listenerProfessionalDataSet;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CompletedTraining(Listener listener, ListenerProfessionalDataSet listenerProfessionalDataSet, Date endDate) {
        this.listener = listener;
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
        this.endDate = endDate;

    }
}
