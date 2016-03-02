package Application.model;

import Application.utils.MysqlUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Listener extends AbstractEntity {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String passSerial;
    private String passNumber;
    private String city;
    private ListenerProfessionalDataSet professionalDataSet;
    private ArrayList<Contract> contracts;

    public Listener() {
        professionalDataSet = new ListenerProfessionalDataSet();
        contracts = new ArrayList<>();
    }


    public Listener(String firstName, String secondName, String patronymic, String passSerial, String passNumber, String city, ListenerProfessionalDataSet professionalDataSet) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.passSerial = passSerial;
        this.passNumber = passNumber;
        this.city = city;
        this.professionalDataSet = professionalDataSet;
        contracts = new ArrayList<>();
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

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public ArrayList<Contract> getContracts() {

        return contracts;
    }

    public String getCity() {
        return city;
    }

    public ListenerProfessionalDataSet getProfessionalDataSet() {
        return professionalDataSet;
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject() {{
            put("id", ID);
            put("first_name", firstName);
            put("second_name", secondName);
            put("patronymic", patronymic);
            put("pass_serial", passSerial);
            put("pass_number", passNumber);
            put("city", city);
            put("professional_data", professionalDataSet.toJSON());
            JSONArray contracts = new JSONArray();
            for (Contract contract : getContracts())
                contracts.add(contract.toJSON());
            put("contracts", contracts);
        }};
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        ID = (int) inputJSON.get("id");
        firstName = (String) inputJSON.get("first_name");
        secondName = (String) inputJSON.get("second_name");
        patronymic = (String) inputJSON.get("patronymic");
        passSerial = (String) inputJSON.get("pass_serial");
        passNumber = (String) inputJSON.get("pass_number");
        city = (String) inputJSON.get("city");
        professionalDataSet.fromJSON((JSONObject) inputJSON.get("professional_data"));
        JSONArray contracts = (JSONArray) inputJSON.get("contracts");
        Iterator i = contracts.iterator();

        while (i.hasNext()) {
            JSONObject contractJSON = (JSONObject) i.next();
            Contract contract = new Contract();
            contract.fromJSON(contractJSON);
            this.contracts.add(contract);
        }
    }

    @Override
    public String toInsertQuery() {
        String insertQuery = "INSERT INTO mydb.listener\n" +
                "(first_name,\n" +
                "second_name,\n" +
                "patronymic,\n" +
                "pass_serial,\n" +
                "pass_number,\n" +
                "city,\n" +
                "academic_rank_id,\n" +
                "academic_degree_id,\n" +
                "subdivision_id,\n" +
                "position_id)\n" +
                "VALUES (\"" + firstName + "\", \"" + secondName + "\", \"" + patronymic + "\", \n" +
                "\"" + passSerial + "\", \"" + passNumber + "\", \"" + city + "\", \"" +
                professionalDataSet.getAcademicRank().getID() + "\", \"" +
                professionalDataSet.getAcademicDegree().getID() + "\", \"" +
                professionalDataSet.getSubdivision().getID() + "\", \"" +
                professionalDataSet.getPosition().getID() + "\");\n";
        return insertQuery;
    }

    @Override
    public String toUpdateQuery() {
        String updateQuery = "UPDATE mydb.listener\n" +
                "SET\n" +
                "first_name = \"" + firstName + "\",\n" +
                "second_name = \"" + secondName + "\",\n" +
                "patronymic = \"" + patronymic + "\",\n" +
                "pass_serial = \"" + passSerial + "\",\n" +
                "pass_number =\"" + passNumber + "\",\n" +
                "city = \"" + city + "\",\n" +
                "academic_rank_id = " + professionalDataSet.getAcademicRank().getID() + ",\n" +
                "academic_degree_id = " + professionalDataSet.getAcademicDegree().getID() + ",\n" +
                "subdivision_id = " + professionalDataSet.getSubdivision().getID() + ",\n" +
                "position_id = " + professionalDataSet.getPosition().getID() + "\n" +
                "WHERE id = " + ID + ";\n";
        return updateQuery;
    }

    @Override
    public String toDeleteQuery() {
        String deleteQuery = "DELETE FROM mydb.listener\n" +
                "WHERE id = " + ID + ";\n";
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
                "    `listener`.`position_id`,\n" +
                "    `academic_degree`.`name`,\n" +
                "    `academic_rank`.`name`,\n" +
                "    `position`.`name`,\n" +
                "\t`subdivision`.`name`    \n" +
                "FROM `mydb`.`listener`, `mydb`.`academic_degree`, `mydb`.`academic_rank`, \n" +
                "\t`mydb`.`position`, `mydb`.`subdivision`\n" +
                "WHERE `listener`.id = " + ID + " \n" +
                "   and`listener`.`academic_rank_id` = `academic_rank`.`id` \n" +
                "   and `listener`.`academic_degree_id` = `academic_degree`.`id`\n" +
                "    and `listener`.`position_id` = `position`.`id`\n" +
                "    and `listener`.`subdivision_id` = `subdivision`.`id`;\n";
        return selectQuery;
    }

    public static Listener fromSelectQuery(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String secondName = resultSet.getString("second_name");
        String patronymic = resultSet.getString("patronymic");
        String passSerial = resultSet.getString("pass_serial");
        String passNumber = resultSet.getString("pass_number");
        String city = resultSet.getString("city");
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        academicDegree.setID(resultSet.getInt("academic_degree_id"));
        academicDegree.setName(resultSet.getString("academic_degree.name"));
        academicRank.setID(resultSet.getInt("academic_rank_id"));
        academicRank.setName(resultSet.getString("academic_rank.name"));
        position.setID(resultSet.getInt("position_id"));
        position.setName(resultSet.getString("position.name"));
        subdivision.setID(resultSet.getInt("subdivision_id"));
        subdivision.setName(resultSet.getString("subdivision.name"));
        ListenerProfessionalDataSet dataSet = new ListenerProfessionalDataSet(subdivision, position, academicDegree, academicRank);

        Listener listener = new Listener(firstName, secondName, patronymic, passSerial, passNumber, city, dataSet);
        listener.setID(ID);
        return listener;

    }

    public void getContractsFromDB(Connection connection) throws SQLException {
        String selectQuery = "SELECT contract.id,\n" +
                "                    contract.sign_date,\n" +
                "                    contract.listener_id,\n" +
                "                    contract.training_program_id,\n" +
                "                    contract.contract_status_id,\n" +
                "                    training_program.name,\n" +
                "                    training_program.category,\n" +
                "                    contract_status.name\n" +
                "                FROM mydb.contract, mydb.contract_status, mydb.training_program\n" +
                "                where contract.listener_id = " + ID + " and training_program.id = contract.training_program_id\n" +
                "                and contract_status.id = contract.contract_status_id;  \n";

        ResultSet rs = MysqlUtils.executeSelectQuery(connection, selectQuery);
        while (rs.next()) {
            contracts.add(Contract.fromSelectQuery(rs));
        }
    }

    public static ArrayList<Listener> getValuesFromDB(Connection connection) throws SQLException {
        ArrayList<Listener> values = new ArrayList<>();
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
                "    `listener`.`position_id`,\n" +
                "    `academic_degree`.`name`,\n" +
                "    `academic_rank`.`name`,\n" +
                "    `position`.`name`,\n" +
                "\t`subdivision`.`name`    \n" +
                "FROM `mydb`.`listener`, `mydb`.`academic_degree`, `mydb`.`academic_rank`, \n" +
                "\t`mydb`.`position`, `mydb`.`subdivision`\n" +
                "WHERE `listener`.`academic_rank_id` = `academic_rank`.`id` \n" +
                "\tand `listener`.`academic_degree_id` = `academic_degree`.`id`\n" +
                "    and `listener`.`position_id` = `position`.`id`\n" +
                "    and `listener`.`subdivision_id` = `subdivision`.`id`;\n";
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, selectQuery);
        while (rs.next()) {
            Listener listener = Listener.fromSelectQuery(rs);
            listener.getContractsFromDB(connection);
            values.add(listener);
        }
        return values;
    }


}
