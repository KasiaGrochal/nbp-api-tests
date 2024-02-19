package stepDefinitions.tablesEndpointSteps;

import enums.Tables;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;
import tablesEndpoint.TablesEndpointRequests;

@Slf4j
public class TablesRequestSteps {

    private Response response;
    private TablesEndpointRequests tablesEndpointRequests;
    private Container container;

    public TablesRequestSteps(Container container) {
        tablesEndpointRequests = new TablesEndpointRequests(Hooks.environmentProperties);
        this.container = container;
    }

    @Given("I send GET table {string} request")
    public void iSendGetTableRequest(String tableType) {
        response = tablesEndpointRequests.sendGetSpecificTableRequest(Tables.getTableByPathParamValue(tableType));
        container.response = response;
    }
}
