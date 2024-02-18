package stepDefinitions;

import enums.CurrencyCodes;
import exchangeEndpoint.TablesEndpointResponses;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepDefinitions.testBase.Container;

public class TablesResponseSteps {

    private Response response;
    private Container container;
    private TablesEndpointResponses tablesEndpointResponses;

    public TablesResponseSteps(Container container) {
        this.container = container;
        response = container.response;
        tablesEndpointResponses = new TablesEndpointResponses(response);
    }

    @When("I filter response to get values for currency code {string}")
    public void iFilterResponseToGetValuesForCurrencyCode(String currencyCode) {
        container.currencyCodes = CurrencyCodes.getCurrencyEnumByCurrencyCode(currencyCode);
        container.rate = tablesEndpointResponses.getRateFromTableForGivenCurrencyCode(currencyCode);
    }

    @When("I filter response to get values for currency name {string}")
    public void iFilterResponseToGetValuesForCurrencyName(String currencyName) {
        container.currencyCodes = CurrencyCodes.getCurrencyEnumByCurrencyName(currencyName);
        container.rate = tablesEndpointResponses.getRateFromTableForGivenCurrencyName(currencyName);
    }

    @When("I filter response to get values for exchange rates higher than {double}")
    public void iFilterResponseToGetValuesForExchangeRatesHigherThan(double above) {
        container.listOfCurrencyNames = tablesEndpointResponses.getListOfCurrenciesWhereMidIsAbove(above);
    }

    @When("I filter response to get values for exchange rates below {double}")
    public void iFilterResponseToGetValuesForExchangeRatesBelow(double below) {
        container.listOfCurrencyNames = tablesEndpointResponses.getListOfCurrenciesWhereMidIsBelow(below);
    }

    @Then("I can print exchange rate for given currency")
    public void iCanPrintExchangeRateForCurrency() {
        System.out.println(container.rate.getMid());
    }

    @Then("I can print appropriate currency names")
    public void iCanPrintCurrencyNames() {
        System.out.println(container.listOfCurrencyNames.toString());
    }
}
