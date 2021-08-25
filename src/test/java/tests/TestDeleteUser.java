package tests;

import io.restassured.response.Response;
import models.Category;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static dataConstants.DataConstants.USERNAME;
import static io.restassured.RestAssured.given;
import static utilsAPI.ApiSpecification.REQUEST_SPECIFICATION;


public class TestDeleteUser {

    @Test
    @DisplayName("User deletion check")
    public void testDeleteUser (){

        Category category = new Category(4, "Human");
        User user = new User();

        Response response = given().spec(REQUEST_SPECIFICATION)
                .baseUri("http://petstore.swagger.io/v2/user/Sv-user")
                .basePath("api/v2/user/")
                .pathParam("username", USERNAME)
                .queryParam("api_key", "api_key")
                .when().delete("{username}")
                .then().statusCode(200)
                .extract().response();
        System.out.println(response.asString());
    }
}




