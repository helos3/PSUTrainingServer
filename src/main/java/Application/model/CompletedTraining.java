package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class CompletedTraining extends AbstractEntity {

    private Listener listener;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;
    private Date endDate;

    public CompletedTraining(Listener listener, ListenerProfessionalDataSet listenerProfessionalDataSet, Date endDate) {
        this.listener = listener;
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
        this.endDate = endDate;
    }

    public CompletedTraining() {
        listener = new Listener();
        listenerProfessionalDataSet = new ListenerProfessionalDataSet();
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
        return new JSONObject() {{
            put("id", ID);
            put("listener", listener.toJSON());
            put("professional_current_data", listenerProfessionalDataSet.toJSON());
            put("end_date", endDate);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        listener.fromJSON((JSONObject) inputJSON.get("listener"));
        listenerProfessionalDataSet.fromJSON((JSONObject) inputJSON.get("professional_current_data"));
        endDate = (Date) inputJSON.get("end_date");
    }


    //TODO: запросы дописать
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
    public void fromSelectQuery(ResultSet resultSet) throws SQLException {

    }
}
