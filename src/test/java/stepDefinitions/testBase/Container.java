package stepDefinitions.testBase;

import configuration.models.EnvironmentProperties;
import enums.CurrencyCodes;
import io.restassured.response.Response;
import models.Rate;

import java.util.List;

public class Container {
    public Response response;
    public Rate rate;
    public List<String> listOfCurrencyNames;

    public CurrencyCodes currencyCodes;

}
