package Application.utils;

/**
 * Created by Rushan on 12.02.2016.
 */
public abstract class AbstractEntity implements JSONAble, MySQLQueries {
    public int ID = -1;

    public boolean idIsNull() {
        if (ID == -1) return true;
        else return false;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

}
