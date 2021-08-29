package tests;

import endpoints.EndPointsForTests;
import io.restassured.response.Response;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static utilsAPI.ApiSpecification.REQUEST_SPECIFICATION;


public class TestDeleteUser {

    @Test
    @DisplayName("User deletion check")
    public void testDeleteUser (){


        User user = new User();

        Response response = given().spec(REQUEST_SPECIFICATION)
                .when()
                .delete(EndPointsForTests.USER + "/" + user.getUsername())
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println(response.asString());
    }
}




