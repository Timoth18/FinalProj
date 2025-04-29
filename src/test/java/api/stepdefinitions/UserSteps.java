
package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserSteps {

    private Response response;
    private String userId;

    @Given("the user ID is {string}")
    public void the_user_id_is(String id) {
        this.userId = id;
    }

    @When("I send GET request to the user endpoint")
    public void i_send_get_request_to_the_user_endpoint() {
        response = given()
                        .baseUri("https://dummyapi.io/data/v1")
                        .header("app-id", "646a3a881fcbaa4fd2491df4")
                   .when()
                        .get("/user/" + userId);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer code) {
        response.then().statusCode(code);
    }

    @Then("the user data should contain {string}")
    public void the_user_data_should_contain(String field) {
        response.then().body("$", hasKey(field));
    }
}
