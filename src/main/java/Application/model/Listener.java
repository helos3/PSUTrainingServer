package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Listener extends AbstractEntity {
    String firstName;
    String secondName;
    String patronymic;
    String passSerial;
    String passNumber;
    String city;
    ListenerProfessionalDataSet professionalDataSet;

    public Listener() {
        professionalDataSet = new ListenerProfessionalDataSet();
    }


    public Listener(String firstName, String secondName, String patronymic, String passSerial, String passNumber, String city, ListenerProfessionalDataSet professionalDataSet) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.passSerial = passSerial;
        this.passNumber = passNumber;
        this.city = city;
        this.professionalDataSet = professionalDataSet;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassSerial(String passSerial) {
        this.passSerial = passSerial;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProfessionalDataSet(ListenerProfessionalDataSet professionalDataSet) {
        this.professionalDataSet = professionalDataSet;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassSerial() {
        return passSerial;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getCity() {
        return city;
    }

    public ListenerProfessionalDataSet getProfessionalDataSet() {
        return professionalDataSet;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("first_name", firstName);
        resultJSON.put("second_name", secondName);
        resultJSON.put("patronymic", patronymic);
        resultJSON.put("pass_serial", passSerial);
        resultJSON.put("pass_number", passNumber);
        resultJSON.put("city", city);
        resultJSON.put("professional_data", professionalDataSet.toJSON());
        return resultJSON;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        firstName = (String) inputJSON.get("first_name");
        secondName = (String) inputJSON.get("second_name");
        patronymic = (String) inputJSON.get("patronymic");
        passSerial = (String) inputJSON.get("pass_serial");
        passNumber = (String) inputJSON.get("pass_number");
        city = (String) inputJSON.get("city");
        professionalDataSet.fromJSON((JSONObject) inputJSON.get("professional_data"));
    }

    @Override
    public String toInsertQuery() {
        String insertQuery = "INSERT INTO `mydb`.`listener`\n" +
                "(`first_name`,\n" +
                "`second_name`,\n" +
                "`patronymic`,\n" +
                "`pass_serial`,\n" +
                "`pass_number`,\n" +
                "`city`,\n" +
                "`academic_rank_id`,\n" +
                "`academic_degree_id`,\n" +
                "`subdivision_id`,\n" +
                "`position_id`)\n" +
                "VALUES (\"" + firstName + "\", \"" +secondName+ "\", \""+ patronymic +"\", \n" +
                "\""+ passSerial+"\", \""+passNumber+"\", \""+city+"\", \"" +
                professionalDataSet.academicRank.getID()+"\", \"" +
                professionalDataSet.academicDegree.getID()+"\", \"" +
                professionalDataSet.subdivision.getID()+"\", \"" +
                professionalDataSet.position.getID()+"\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE `mydb`.`listener`\n" +
                "SET\n" +
                "`first_name` = \""+ firstName +"\",\n" +
                "`second_name` = \"" + secondName+"\",\n" +
                "`patronymic` = \""+patronymic+"\",\n" +
                "`pass_serial` = \""+passSerial+"\",\n" +
                "`pass_number` =\""+passNumber+"\",\n" +
                "`city` = \""+city+"\",\n" +
                "`academic_rank_id` = "+professionalDataSet.academicRank.getID()+",\n" +
                "`academic_degree_id` = "+professionalDataSet.academicDegree.getID()+",\n" +
                "`subdivision_id` = "+professionalDataSet.subdivision.getID()+",\n" +
                "`position_id` = "+professionalDataSet.position.getID()+"\n" +
                "WHERE `id` = "+ID+";\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM `mydb`.`listener`\n" +
                "WHERE `id` = "+ID+";\n";
        return deleteQuery;
    }

    @Override
    public String toSelectQuery() {
        String selectQuery = "SELECT `listener`.`id`,\n" +
                "    `listener`.`first_name`,\n" +
                "    `listener`.`second_name`,\n" +
                "    `listener`.`patronymic`,\n" +
                "    `listener`.`pass_serial`,\n" +
                "    `listener`.`pass_number`,\n" +
                "    `listener`.`city`,\n" +
                "    `listener`.`academic_rank_id`,\n" +
                "    `listener`.`academic_degree_id`,\n" +
                "    `listener`.`subdivision_id`,\n" +
                "    `listener`.`position_id`\n" +
                "FROM `mydb`.`listener`\n" +
                "WHERE `id` = "+ID+";\n";
        return selectQuery;
    }

    @Override
    public void fromSelectQuery(ResultSet resultSet) throws SQLException {
        firstName = resultSet.getString("first_name");
        secondName = resultSet.getString("second_name");
        patronymic = resultSet.getString("patronymic");
        passSerial = resultSet.getString("pass_serial");
        passNumber = resultSet.getString("pass_number");
        city = resultSet.getString("city");
        professionalDataSet.academicRank.setID(resultSet.getInt("academic_rank_id"));
        professionalDataSet.academicDegree.setID(resultSet.getInt("academic_degree_id"));
        professionalDataSet.subdivision.setID(resultSet.getInt("subdivision_id"));
        professionalDataSet.position.setID(resultSet.getInt("position_id"));


    }
}
