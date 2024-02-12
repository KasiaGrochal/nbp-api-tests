package configuration.models;

import lombok.Data;

@Data
public class EnvironmentProperties {

    private Long expectedResponseTime;
    private String baseUri;
    private String pathToExchangeRates;
    private String pathToTables;
}
