package api;

import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;

public class BaseApiTest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
