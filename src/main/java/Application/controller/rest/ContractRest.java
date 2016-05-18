package Application.controller.rest;

import Application.model.entities.AcademicDegree;
import Application.model.entities.AcademicRank;
import Application.model.entities.Contract;
import Application.model.entities.TrainingProgram;
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
public class ContractRest {

    @Resource(name = "contractServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/contract", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<Contract> contracts = service.getAll();
        mapper.writeValue(out, contracts);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        Contract contract = (Contract) service.find(id);
        if (contract == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(contract);
        return result;
    }

    @RequestMapping(value = "/contract", method = RequestMethod.PUT)
    @ResponseBody
    public String putSingle(@RequestBody String body,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            Contract contract = new ObjectMapper().reader(Contract.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(contract));
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/contract/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@RequestBody String body,
                             @PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        Contract contract = (Contract) service.find(id);
        if (contract == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else

            service.remove(id);
    }


}
