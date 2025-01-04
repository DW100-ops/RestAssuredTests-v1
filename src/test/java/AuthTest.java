import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AuthTest  {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://recruit-stage.portnov.com/recruit/api/v1";
    }


    @Test
    public void testLogin() throws IOException {
        String message = new String(Files.readAllBytes(Paths.get("src/test/resources/studentlogin.json")));

        given()
                .contentType("application/json")
                .body(message)
                .when()
                .post("/login")
                .then()
                .statusCode(200);


    }

}
