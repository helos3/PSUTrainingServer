package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Contract extends AbstractEntity {

    private int listenerID;
    private Date signDate;
    private String signDateString;
    private CategoryFactory.ContractStatus contractStatus;
    private TrainingProgram trainingProgram;
    private Graduate graduate;

    public void setListenerID(int listenerID) {
        this.listenerID = listenerID;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setContractStatus(CategoryFactory.ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public void setGraduate(Graduate graduate) {
        this.graduate = graduate;
    }

    public int getListenerID() {

        return listenerID;
    }

    public Date getSignDate() {
        return signDate;
    }

    public String getSignDateString() {
        return signDateString;
    }

    public CategoryFactory.ContractStatus getContractStatus() {
        return contractStatus;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public Graduate getGraduate() {
        return graduate;
    }

    public Contract() {
        contractStatus = new CategoryFactory().contractStatusCreate();
        trainingProgram = new TrainingProgram();
        graduate = new Graduate();

    }

    public void setSignDateString(String signDateString) {
        this.signDateString = signDateString;
    }

    public Contract(TrainingProgram trainingProgram, CategoryFactory.ContractStatus contractStatus, int listenerID, Date signDate) {
        this.trainingProgram = trainingProgram;
        this.contractStatus = contractStatus;
        this.signDate = signDate;
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        signDateString = format.format(signDate);
        this.listenerID = listenerID;
        graduate = new Graduate();
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject() {{
            put("id", ID);
            put("sign_date", signDateString);
            put("training_program", trainingProgram.toJSON());
            put("contract_status", contractStatus.toJSON());
            put("listener_id", listenerID);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");

        try {
            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            signDateString = (String) inputJSON.get("sign_date");
            signDate = format.parse(signDateString);
        } catch (Exception e) {
        }
        trainingProgram.fromJSON((JSONObject) inputJSON.get("training_program"));
        contractStatus.fromJSON((JSONObject) inputJSON.get("contract_status"));
        listenerID = (int) inputJSON.get("listener_id");
    }

    @Override
    public String toInsertQuery() {
        String insertQuery = "INSERT INTO mydb.contract\n" +
                "(sign_date,\n" +
                "listener_id,\n" +
                "training_program_id,\n" +
                "contract_status_id)\n" +
                "VALUES\n" +
                "(\"" + signDateString + "\",\n" +
                listenerID + ",\n" +
                trainingProgram.getID() + ",\n" +
                contractStatus.getID() + "1);";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE mydb.contract\n" +
                "SET\n" +
                "sign_date = " + signDateString + ",\n" +
                "listener_id = " + listenerID + ",\n" +
                "training_program_id = " + trainingProgram.getID() + ",\n" +
                "contract_status_id = " + contractStatus.getID() + "\n" +
                "WHERE id = " + ID + " AND listener_id = " + listenerID + ";\n";
        return updateQuery;

    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM mydb.contract\n" +
                "WHERE id = " + ID + ";";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "SELECT contract.id,\n" +
                "    contract.number,\n" +
                "    contract.sign_date,\n" +
                "    contract.listener_id,\n" +
                "    contract.training_program_id,\n" +
                "    contract.contract_status_id\n" +
                "FROM mydb.contract\n" +
                "WHERE id = " + ID + ";";
        return selectQuery;
    }


    public static Contract fromSelectQuery(ResultSet rs, int listenerID) throws SQLException {
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.ContractStatus contractStatus = factory.contractStatusCreate();
        contractStatus.setName(rs.getString("contract_status.name"));
        contractStatus.setID(rs.getInt("contract.contract_status_id"));
        TrainingProgram trainingProgram = new TrainingProgram(
                rs.getString("training_program.name"), rs.getString("training_program.category"));
        trainingProgram.setID(rs.getInt("contract.training_program_id"));
        java.sql.Date signDate = rs.getDate("sign_date");
        return new Contract(trainingProgram, contractStatus, listenerID, signDate) {{
            setGraduate(new Graduate());
        }};
    }

    public void getGraduateFromDB(Connection connection) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT graduate.id,\n" +
                "    graduate.contract_id,\n" +
                "    graduate.complete_date,\n" +
                "    graduate.current_academic_rank_id,\n" +
                "    graduate.current_academic_degree_id,\n" +
                "    graduate.current_subdivision_id,\n" +
                "    graduate.current_position_id,\n" +
                "    academic_degree.name,\n" +
                "    academic_rank.name,\n" +
                "    position.name,\n" +
                "    subdivision.name\n" +
                "FROM mydb.graduate, mydb.academic_degree, mydb.academic_rank, mydb.position, mydb.subdivision\n" +
                "WHERE contract_id = " + ID + "  \n" +
                "\tand academic_degree.id = graduate.current_academic_degree_id \n" +
                "    and academic_rank.id = graduate.current_academic_rank_id\n" +
                "    and position.id = graduate.current_position_id\n" +
                "    and subdivision.id = graduate.current_subdivision_id;\n");

        if (stmt.execute("SELECT graduate.id,\n" +
                "    graduate.contract_id,\n" +
                "    graduate.complete_date,\n" +
                "    graduate.current_academic_rank_id,\n" +
                "    graduate.current_academic_degree_id,\n" +
                "    graduate.current_subdivision_id,\n" +
                "    graduate.current_position_id,\n" +
                "    academic_degree.name,\n" +
                "    academic_rank.name,\n" +
                "    position.name,\n" +
                "    subdivision.name\n" +
                "FROM mydb.graduate, mydb.academic_degree, mydb.academic_rank, mydb.position, mydb.subdivision\n" +
                "WHERE contract_id = " + ID + "  \n" +
                "\tand academic_degree.id = graduate.current_academic_degree_id \n" +
                "    and academic_rank.id = graduate.current_academic_rank_id\n" +
                "    and position.id = graduate.current_position_id\n" +
                "    and subdivision.id = graduate.current_subdivision_id;\n")) {
            rs = stmt.getResultSet();
        }
        rs.next();
        graduate = Graduate.fromSelectQuery(rs);
    }
}
