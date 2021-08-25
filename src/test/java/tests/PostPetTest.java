package tests;

import com.google.gson.JsonParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class PostPetTest {
    String baseUri = "https://petstore.swagger.io/v2";
    String status = "/pet/findByStatus";

    RequestSpecification rs = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setContentType(ContentType.JSON)
            .log(LogDetail.METHOD)
            .log(LogDetail.URI)
            .log(LogDetail.HEADERS)
            .log(LogDetail.BODY)
            .build();


    @Test
    public void testPostPet() {
        String idTestValue = RandomStringUtils.randomNumeric(5);
        Response response = given()
                .spec(rs)
                .when()
                .body("{\n" +
                        "\"id\":" + idTestValue + ",\n" +
                        "\"name\":\"Mari\",\n" +
                        "\"photoUrls\":[],\n" +
                        "\"tags\":[],\n" +
                        "\"status\":\"pending\"\n" +
                        "}")
                .post();

        response.prettyPrint();
        String responseBody = response.getBody().asString();
        JsonParser parser = new JsonParser();
        Long id = parser.parse(responseBody).getAsJsonArray().get(2).getAsJsonObject().get("id").getAsLong();
        System.out.println(id);

    }
}
