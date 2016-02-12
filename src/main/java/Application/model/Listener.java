package Application.model;

import org.json.simple.JSONObject;
import Application.utils.AbstractEntity;

import java.sql.ResultSet;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Listener extends AbstractEntity {
    private int age;
    private String passSerial, passNumber, firstName, secondName, patronymicName, city;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;

    public Listener(int age, String passSerial, String passNumber, String firstName, String secondName, String patronymicName, String city, ListenerProfessionalDataSet listenerProfessionalDataSet) {
        this.age = age;
        this.passSerial = passSerial;
        this.passNumber = passNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
        this.city = city;
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
    }


    public void setListenerProfessionalDataSet(ListenerProfessionalDataSet listenerProfessionalDataSet) {
        this.listenerProfessionalDataSet = listenerProfessionalDataSet;
    }

    public ListenerProfessionalDataSet getListenerProfessionalDataSet() {

        return listenerProfessionalDataSet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassSerial(String passSerial) {
        this.passSerial = passSerial;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {

        return age;
    }

    public String getPassSerial() {
        return passSerial;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String getCity() {
        return city;
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
