package exchangeEndpoint;

import commons.CommonRequestSpecification;
import configuration.models.EnvironmentProperties;
import enums.Tables;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class TablesEndpointRequests extends CommonRequestSpecification {

    private EnvironmentProperties environmentProperties;
    private String basePath;

    public TablesEndpointRequests(EnvironmentProperties environmentProperties) {
        this.environmentProperties = environmentProperties;
        this.basePath = environmentProperties.getPathToExchangeRates() + environmentProperties.getPathToTables();
    }

    public Response sendGetSpecificTableRequest(Tables tables) {
        return given().
                spec(getTablesEndpointRequestSpec()).
                when().
                get(tables.getSpecificTableEndpoint());
    }

    private RequestSpecification getTablesEndpointRequestSpec() {
        return new RequestSpecBuilder().
                addRequestSpecification(getCommonRequestSpecification(environmentProperties)).
                setBasePath(basePath).
                build();
    }


}
