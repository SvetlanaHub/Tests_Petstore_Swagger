package tests;

import endpoints.EndPointsForTests;
import models.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static utilsAPI.ApiSpecification.REQUEST_SPECIFICATION;
import static utilsAPI.SchemaPath.orderJsonSchema;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestPostStoreOrder {

    @Test
    @DisplayName("Checking the order for a pet")
    public void testPostStoreOrder () {

        Order order = new Order(1, 6, 9,
                "2021-08-25T15:31:41.369Z", "placed", true);

        given().spec(REQUEST_SPECIFICATION)
                .when()
                .body(order)
                .post(EndPointsForTests.STORE + EndPointsForTests.ORDER)
                .then()
                .assertThat()
                .body(matchesJsonSchema(orderJsonSchema));

    }

}

