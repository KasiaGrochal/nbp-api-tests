package loaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.Table;

@Slf4j
public class JsonLoader {

    public static Table getTableFromResponse(Response response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Table[] tables = objectMapper.readValue(response.asString(), Table[].class);
            return tables[0];
        } catch (JsonProcessingException e) {
            log.error("Caught exception while loading response to Table model");
        }
        throw new RuntimeException("Unable to retrieve Table object from json response");
    }

}
