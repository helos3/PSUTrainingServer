package model;

import java.util.ArrayList;

/**
 * Created by Rushan on 10.02.2016.
 */
public class TrainingProgram {
    private String name, cathegory;
    private ArrayList<Module> modules;

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setName(String name) {
        this.name = name;
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

    public TrainingProgram(String name, String cathegory) {
        modules = new ArrayList<>();
        this.name = name;
        this.cathegory = cathegory;
    }
}
