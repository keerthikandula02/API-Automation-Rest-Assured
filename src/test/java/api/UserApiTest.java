package api;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class UserApiTest extends BaseApiTest {
    @Test
    void getUserShouldReturnValidResponse() {
        given().when().get("/users/1").then().statusCode(200).time(lessThan(3000L)).body("id", equalTo(1)).body("name", not(emptyOrNullString()));
    }

    @Test
    void missingUserShouldReturnNotFound() {
        given().when().get("/users/9999").then().statusCode(404);
    }

    @Test
    void createUserShouldReturnCreated() {
        String body = "{\"name\":\"Keerthi\",\"username\":\"qa_user\",\"email\":\"qa@example.com\"}";
        given().contentType("application/json").body(body).when().post("/users").then().statusCode(201).body("name", equalTo("Keerthi"));
    }

    @Test
    void updateUserShouldReturnUpdatedData() {
        String body = "{\"name\":\"Keerthi QA\"}";
        given().contentType("application/json").body(body).when().put("/users/1").then().statusCode(200).body("name", equalTo("Keerthi QA"));
    }

    @Test
    void deleteUserShouldSucceed() {
        when().delete("/users/1").then().statusCode(200);
    }
}
