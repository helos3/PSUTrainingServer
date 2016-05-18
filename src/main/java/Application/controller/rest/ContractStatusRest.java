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
public class ContractStatusRest {

    @Resource(name = "contractStatusServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/contract_status", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<ContractStatus> statuses = service.getAll();
        mapper.writeValue(out, statuses);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/contract_status/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        ContractStatus contractStatus = (ContractStatus) service.find(id);
        if (contractStatus == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(contractStatus);
        return result;
    }

    @RequestMapping(value = "/contract_status", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            ContractStatus status = new ObjectMapper().reader(ContractStatus.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(status));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/contract_status/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@RequestBody String body,
                             @PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        ContractStatus contractStatus= (ContractStatus) service.find(id);
        if (contractStatus == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);
    }
}