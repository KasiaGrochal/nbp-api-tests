package exchangeEndpoint;

import commons.RestBase;
import configuration.models.EnvironmentProperties;
import enums.Tables;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class TablesEndpointRequests extends RestBase {

    private String pathToTables;
    private RequestSpecification requestSpecification;

    public TablesEndpointRequests(EnvironmentProperties environmentProperties) {
        super(environmentProperties);
        pathToTables = environmentProperties.getPathToTables();
        requestSpecification = getCommonRequestSpecification().basePath(environmentProperties.getPathToExchangeRates() + pathToTables);
    }

    public Response sendGetSpecificTableRequest(Tables tables) {
        return given().
                spec(requestSpecification).
                pathParams(pathToTables, tables.getSpecificTableEndpoint()).
                when().
                get("{" + pathToTables + "}");
    }

}
