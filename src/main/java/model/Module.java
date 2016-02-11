package model;

/**
 * Created by Rushan on 10.02.2016.
 */
public class Module {
    int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {

        return ID;
    }

    public Module(int ID, String name) {

        this.ID = ID;
        this.name = name;
    }

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
