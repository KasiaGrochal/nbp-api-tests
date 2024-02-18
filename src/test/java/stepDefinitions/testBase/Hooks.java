package stepDefinitions.testBase;

import configuration.ConfigReader;
import configuration.models.EnvironmentProperties;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Hooks {


    public static EnvironmentProperties environmentProperties;

    @BeforeAll
    public static void before_or_after_all() {
        log.info("Initializing environment properties");
        environmentProperties = new ConfigReader().getConfig().getEnvironmentProperties();
    }

    @After
    public void tearDown(Scenario scenario) {
        hasScenarioFail(scenario);
    }

    private void hasScenarioFail(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Error while executing scenario: {}, test failed", scenario.getName());
        }
    }
}