package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static io.restassured.RestAssured.given;
import static utilsAPI.ApiSpecification.REQUEST_SPECIFICATION;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestGetLogin {
    String baseUri = "https://petstore.swagger.io/v2/user/login?username=Sv-user&password=dok-12";

    @Test
    @DisplayName("Check login status code")
    public void testGetLogin() {
        Response response = given()
                .spec(REQUEST_SPECIFICATION)
                .baseUri(baseUri)
                .accept(ContentType.JSON)
                .queryParam("username", "Sv-user")
                .queryParam("password", "dok-12")
                .when()
                .when().get()
                .then()
                .extract().response();
        String statusLine =response.statusLine().substring(13,15);
        String jsonBody = response.getBody().asString();
        try {
            Assertions.assertNotNull(jsonBody);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        Assertions.assertEquals(statusLine,"OK");
    }

}
