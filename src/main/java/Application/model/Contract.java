package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Contract extends AbstractEntity {

    private Date signDate;
    private Listener listener;
    private CategoryFactory.ContractStatus contractStatus;
    private TrainingProgram trainingProgram;

    public Contract() {
        contractStatus = new CategoryFactory().contractStatusCreate();
        trainingProgram = new TrainingProgram();
        listener = new Listener();
    }

    public Contract(TrainingProgram trainingProgram, CategoryFactory.ContractStatus contractStatus, Listener listener, Date signDate) {
        this.trainingProgram = trainingProgram;
        this.contractStatus = contractStatus;
        this.listener = listener;
        this.signDate = signDate;
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject(){{
            put("id", ID);
            put("sign_date", signDate);
            put("listener", listener.toJSON());
            put("training_program", trainingProgram.toJSON());
            put("contract_status", contractStatus.toJSON());
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        signDate = (Date) inputJSON.get("sign_date");
        listener.fromJSON((JSONObject) inputJSON.get("listener"));
        trainingProgram.fromJSON((JSONObject) inputJSON.get("training_program"));
        contractStatus.fromJSON((JSONObject) inputJSON.get("contract_status"));
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
