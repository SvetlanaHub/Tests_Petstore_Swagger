package utilsAPI;
import endpoints.EndPointsForTests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class ApiSpecification {

    public static final RequestSpecification REQUEST_SPECIFICATION = ApiSpecification.getRequestSpecification();

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(EndPointsForTests.BASEURI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .build();
    }
}
