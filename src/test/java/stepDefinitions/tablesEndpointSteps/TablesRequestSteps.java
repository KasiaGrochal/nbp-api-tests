package stepDefinitions.tablesEndpointSteps;

import configuration.models.EnvironmentProperties;
import enums.Tables;
import tablesEndpoint.TablesEndpointRequests;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;

@Slf4j
public class TablesRequestSteps {

    private Response response;
    private TablesEndpointRequests tablesEndpointRequests;
    private EnvironmentProperties environmentProperties;
    private Container container;

    public TablesRequestSteps(Container container) {
        environmentProperties = Hooks.environmentProperties;
        tablesEndpointRequests = new TablesEndpointRequests(environmentProperties);
        this.container = container;
    }

    @Given("I send GET table {string} request")
    public void iSendGetTableRequest(String tableType) {
        response = tablesEndpointRequests.sendGetSpecificTableRequest(Tables.getTableByTableType(tableType));
        container.response = response;
    }
}
