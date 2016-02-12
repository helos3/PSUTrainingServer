package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class CompletedTraining extends AbstractEntity {

    private Listener listener;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;
    private Date endDate;

    public CompletedTraining(int contractNumber, Listener listener, ListenerProfessionalDataSet listenerProfessionalDataSet, Date endDate) {
        this.listener = listener;
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
        this.endDate = endDate;
    }


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
}
