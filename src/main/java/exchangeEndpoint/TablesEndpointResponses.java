package exchangeEndpoint;

import io.restassured.response.Response;
import loaders.JsonLoader;
import models.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TablesEndpointResponses {

    private ArrayList<Rate> rates;

    public TablesEndpointResponses(Response response) {
        this.rates = getListOfRates(response);
    }


    public Rate getRateFromTableForGivenCurrencyCode(String currencyCode) {
        return rates.stream().
                filter(x -> x.getCode().equals(currencyCode)).
                findFirst().
                orElseThrow();
    }

    public Rate getRateFromTableForGivenCurrencyName(String currencyName) {
        return rates.stream().
                filter(x -> x.getCurrency().equals(currencyName)).
                findFirst().
                orElseThrow();
    }

    public List<String> getListOfCurrenciesWhereMidIsAbove(double above) {
        return rates.stream()
                .filter(x -> x.getMid() > above)
                .map(Rate::getCurrency)
                .collect(Collectors.toList());
    }

    public List<String> getListOfCurrenciesWhereMidIsBelow(double below) {
        return rates.stream()
                .filter(x -> x.getMid() < below)
                .map(Rate::getCurrency)
                .collect(Collectors.toList());
    }

    private static ArrayList<Rate> getListOfRates(Response response) {
        return JsonLoader.
                getTableFromResponse(response).
                getRates();
    }
}
