package Application.controller.rest;

import Application.model.entities.*;
import Application.model.services.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by Rushan on 15.05.2016.
 */
@RestController
@RequestMapping("/data")
public class ListenerRest {

    @Resource(name = "listenerServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/listener", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<Listener> listeners = service.getAll();
        mapper.writeValue(out, listeners);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/listener/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        Listener listener = (Listener) service.find(id);
        if (listener == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(listener);
        return result;
    }

    @RequestMapping(value = "/listener", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            Listener listener = new ObjectMapper().reader(Listener.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(listener));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/listener/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        Listener listener= (Listener) service.find(id);
        if (listener == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);
    }
}