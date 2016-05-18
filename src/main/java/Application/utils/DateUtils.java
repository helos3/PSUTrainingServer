package Application.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rushan on 17.05.2016.
 */
public class DateUtils {
    private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(Date date) {
        return formatter.format(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        return formatter.parse(date);
    }

}

//public class DateDeserialize extends JsonDeserializer<Date> {
//
//    @Override
//    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
//        final JsonNode node = (JsonNode) mapper.readTree(jsonParser);
//        String toStr = node.toString();
//        toStr
//    }
//}
