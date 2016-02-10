package model;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Listener {
    private int age;
    private String passSerial, passNumber, firstName, secondName, patronymicName, city;
    private ListenerProfessionalDataSet listenerProfessionalDataSet;

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

    public Listener(int age, String passSerial, String passNumber, String firstName, String secondName, String patronymicName, String city) {

        this.age = age;
        this.passSerial = passSerial;
        this.passNumber = passNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
        this.city = city;
    }
}
