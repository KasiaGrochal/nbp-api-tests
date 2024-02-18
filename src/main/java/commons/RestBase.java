package commons;

import configuration.models.EnvironmentProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;

@Getter
public class RestBase {


    protected RequestSpecification commonRequestSpecification;
    protected ResponseSpecification commonResponseSpecification;

    public RestBase(EnvironmentProperties environmentProperties) {
        commonRequestSpecification = new RequestSpecBuilder().
                setBaseUri(environmentProperties.getBaseUri()).
                setContentType(ContentType.JSON).
                build();
        commonResponseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                build();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
