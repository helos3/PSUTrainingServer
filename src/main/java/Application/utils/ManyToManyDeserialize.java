package Application.utils;

import Application.model.entities.Module;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rushan on 18.05.2016.
 */
public class ManyToManyDeserialize extends JsonDeserializer<List<Module>> {

    @Override
    public List<Module> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        final JsonNode node = (JsonNode) mapper.readTree(jsonParser);

        String toStr = node.toString();
        toStr = StringUtils.replace(toStr, "\"{", "{");
        toStr = StringUtils.replace(toStr, "}\"", "}");
        toStr = StringUtils.remove(toStr, "\\r\\n");
        toStr = StringUtils.remove(toStr, "\\");

        final JsonNode newNode = mapper.readTree(toStr);

        final Module[] modules = mapper.convertValue(newNode, Module[].class);

        return Arrays.asList(modules);

    }
}
