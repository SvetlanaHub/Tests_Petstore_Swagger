package utilsAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import utils.Log;

public class JsonConv {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger log = Logger.getLogger(Log.class);
    public static String convObjectToJson(Object o){

        String jsonBody = "";

        try {
            jsonBody = OBJECT_MAPPER.writeValueAsString(o);
            log.info("JsonBody was created successfully.");

        } catch (JsonProcessingException e) {

            log.error("Can't create jsonBody:\n{}", e);
        }

        return jsonBody;
    }
}
