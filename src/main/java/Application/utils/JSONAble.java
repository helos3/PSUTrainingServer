package Application.utils;


import org.json.simple.JSONObject;

/**
 * Created by Rushan on 12.02.2016.
 */
public interface JSONAble {
    public JSONObject toJSON();
    public void fromJSON(JSONObject inputJSON);
}
