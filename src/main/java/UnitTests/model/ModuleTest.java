package UnitTests.model;

import Application.model.Module;
import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * Created by Rushan on 12.02.2016.
 */
public class ModuleTest {

    @Test
    public void testToJSON1() throws Exception {
        Module module = new Module();
        module.setName("qwe");
        module.setID(12);
        System.out.println(module.toJSON().toString());
    }

    @Test
    public void testToJSON2() throws Exception {
        Module module = new Module();
        module.setName("qwe");
        System.out.println(module.toJSON().toString());
    }

    @Test
    public void testFromJSON1() throws Exception {
        JSONObject jsonObject = new JSONObject();
        Module module = new Module();
        jsonObject.put("idParam", false);
        jsonObject.put("name", "module1");
        module.fromJSON(jsonObject);
        System.out.println(module.toJSON().toString());
    }

    @Test
    public void testFromJSON2() throws Exception {
        JSONObject jsonObject = new JSONObject();
        Module module = new Module();
        jsonObject.put("idParam", true);
        jsonObject.put("name", "module1");
        jsonObject.put("id", 15);
        module.fromJSON(jsonObject);
        System.out.println(module.toJSON().toString());
    }

    @Test
    public void testToInsertQuery() throws Exception {
        Module module = new Module();
        module.setName("qwe");
        module.setID(12);
        System.out.println(module.toInsertQuery());
    }
}