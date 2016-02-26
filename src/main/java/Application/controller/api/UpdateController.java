package Application.controller.api;

import Application.model.EntityFactory;
import Application.utils.AbstractEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Rushan on 25.02.2016.
 */
@RestController
public class UpdateController {

    @RequestMapping(value = "/{tableName}/{action}", method = RequestMethod.POST)
    public String updateTable(@PathVariable(value = "tableName") final String tableName,
                      @PathVariable(value = "action") final String action,
                      @RequestBody String json) throws Exception {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
//        AbstractEntity entity = EntityFactory.createEntity(tableName);
        JSONArray jsonArray = (JSONArray)jsonObject.get("objects");
        return null;
    }

}
