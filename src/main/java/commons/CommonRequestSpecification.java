package commons;

import configuration.models.EnvironmentProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class CommonRequestSpecification {
    public static RequestSpecification getCommonRequestSpecification(EnvironmentProperties environmentProperties) {
        return new RequestSpecBuilder().
                setBaseUri(environmentProperties.getBaseUri()).
                build().
                filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
