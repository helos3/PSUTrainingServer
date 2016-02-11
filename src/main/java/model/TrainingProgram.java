package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram {
    private int ID;
    private String name, cathegory;
    private HashMap<Integer, Module> modules; //key - id, value - name


    public void setName(String name) {
        this.name = name;
    }

    public TrainingProgram(int ID, String name, String cathegory) {
        this.ID = ID;
        this.name = name;
        this.cathegory = cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public String getName() {

        return name;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setModules(HashMap<Integer, Module> modules) {
        this.modules = modules;
    }

    public int getID() {

        return ID;
    }

    public HashMap<Integer, Module> getModules() {
        return modules;
    }
}
