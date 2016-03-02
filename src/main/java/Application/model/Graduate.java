package Application.model;

import Application.utils.MysqlUtils;
import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Graduate extends AbstractEntity {

    private int contractID;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;
    private Date endDate;
    private String endDateString;

    public Graduate(int contractID, ListenerProfessionalDataSet listenerProfessionalDataSet, Date endDate) {
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
        this.endDate = endDate;
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        endDateString = format.format(endDate);
        this.contractID = contractID;
    }

    public Graduate() {
        listenerProfessionalDataSet = new ListenerProfessionalDataSet();
    }


    public void setListenerProfessionalDataSet(ListenerProfessionalDataSet listenerProfessionalDataSet) {
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        endDateString = format.format(endDate);
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
            put("contract_id", contractID);
            put("professional_current_data", listenerProfessionalDataSet.toJSON());
            put("end_date", endDateString);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        contractID = (int) inputJSON.get("contract_id");
//        contract.fromJSON((JSONObject) inputJSON.get("contract"));
        listenerProfessionalDataSet.fromJSON((JSONObject) inputJSON.get("professional_current_data"));
//        endDate = (Date) inputJSON.get("end_date");
        try {
            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            endDateString = (String) inputJSON.get("end_date");
            endDate = format.parse(endDateString);
        } catch (Exception e) {
        }

    }


    @Override
    public String toInsertQuery() {
        String insertQuery = "INSERT INTO mydb.graduate\n" +
                "(contract_id,\n" +
                "complete_date,\n" +
                "current_academic_rank_id,\n" +
                "current_academic_degree_id,\n" +
                "current_subdivision_id,\n" +
                "current_position_id)\n" +
                "VALUES\n" +
                "(" + contractID + ",\n" +
                "\"" + endDateString + "\",\n" +
                listenerProfessionalDataSet.getAcademicRank().getID() + ",\n" +
                listenerProfessionalDataSet.getAcademicDegree().getID() + ",\n" +
                listenerProfessionalDataSet.getSubdivision().getID() + ",\n" +
                listenerProfessionalDataSet.getPosition().getID() + ");";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE mydb.graduate\n" +
                "SET\n" +
                "contract_id = " + contractID + ",\n" +
                "complete_date = \"" + endDateString + "\",\n" +
                "current_academic_rank_id = " + listenerProfessionalDataSet.getAcademicRank().getID() + ",\n" +
                "current_academic_degree_id = " + listenerProfessionalDataSet.getAcademicDegree().getID() + ",\n" +
                "current_subdivision_id = " + listenerProfessionalDataSet.getSubdivision().getID() + ",\n" +
                "current_position_id = " + listenerProfessionalDataSet.getPosition().getID() + "\n" +
                "WHERE id = " + ID + " AND contract_id = " + contractID + ";\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM mydb.graduate\n" +
                "WHERE id = " + ID + ";\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "SELECT `graduate`.`id`,\n" +
                "    `graduate`.`contract_id`,\n" +
                "    `graduate`.`complete_date`,\n" +
                "    `graduate`.`current_academic_rank_id`,\n" +
                "    `graduate`.`current_academic_degree_id`,\n" +
                "    `graduate`.`current_subdivision_id`,\n" +
                "    `graduate`.`current_position_id`,\n" +
                "    `academic_degree`.`name`,\n" +
                "    `academic_rank`.`name`,\n" +
                "    `position`.`name`,\n" +
                "\t`subdivision`.`name`    \n" +
                "FROM `mydb`.`graduate`, `mydb`.`academic_degree`, `mydb`.`academic_rank`, \n" +
                "\t`mydb`.`position`, `mydb`.`subdivision`\n" +
                "WHERE graduate.id = " + ID + "\n" +
                "and `graduate`.`current_academic_rank_id` = `academic_rank`.`id` \n" +
                "\tand `graduate`.`current_academic_degree_id` = `academic_degree`.`id`\n" +
                "    and `graduate`.`current_position_id` = `position`.`id`\n" +
                "    and `graduate`.`current_subdivision_id` = `subdivision`.`id`;\n";
        return selectQuery;
    }


    public static Graduate fromSelectQuery(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("graduate.id");
        Date endDate = resultSet.getDate("graduate.complete_date");
        int contractID = resultSet.getInt("graduate.contract_id");
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        academicDegree.setID(resultSet.getInt("graduate.current_academic_degree_id"));
        academicDegree.setName(resultSet.getString("academic_degree.name"));
        academicRank.setID(resultSet.getInt("graduate.current_academic_rank_id"));
        academicRank.setName(resultSet.getString("academic_rank.name"));
        position.setID(resultSet.getInt("graduate.current_position_id"));
        position.setName(resultSet.getString("position.name"));
        subdivision.setID(resultSet.getInt("graduate.current_subdivision_id"));
        subdivision.setName(resultSet.getString("subdivision.name"));
        ListenerProfessionalDataSet dataSet = new ListenerProfessionalDataSet(subdivision, position, academicDegree, academicRank);
        Graduate graduate = new Graduate(contractID, dataSet, endDate);
        graduate.setID(ID);
        return graduate;
    }


    public static ArrayList<Graduate> getValuesFromDB(Connection connection) throws SQLException {
        ArrayList<Graduate> values = new ArrayList<>();
        String selectQuery = "SELECT `graduate`.`id`,\n" +
                "    `graduate`.`contract_id`,\n" +
                "    `graduate`.`complete_date`,\n" +
                "    `graduate`.`current_academic_rank_id`,\n" +
                "    `graduate`.`current_academic_degree_id`,\n" +
                "    `graduate`.`current_subdivision_id`,\n" +
                "    `graduate`.`current_position_id`,\n" +
                "    `academic_degree`.`name`,\n" +
                "    `academic_rank`.`name`,\n" +
                "    `position`.`name`,\n" +
                "\t`subdivision`.`name`    \n" +
                "FROM `mydb`.`graduate`, `mydb`.`academic_degree`, `mydb`.`academic_rank`, \n" +
                "\t`mydb`.`position`, `mydb`.`subdivision`\n" +
                "WHERE `graduate`.`current_academic_rank_id` = `academic_rank`.`id` \n" +
                "\tand `graduate`.`current_academic_degree_id` = `academic_degree`.`id`\n" +
                "    and `graduate`.`current_position_id` = `position`.`id`\n" +
                "    and `graduate`.`current_subdivision_id` = `subdivision`.`id`;\n";
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, selectQuery);
        while (rs.next()) {
            Graduate graduate = Graduate.fromSelectQuery(rs);
            values.add(graduate);
        }
        return values;
    }

}
