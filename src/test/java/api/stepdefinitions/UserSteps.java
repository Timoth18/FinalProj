package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private Response response;
    private String userId;

    @Given("the user ID is {string}")
    public void theUserIDIs(String id) {
        this.userId = id;
    }

    @When("I send GET request to the user endpoint")
    public void iSendGETRequestToTheUserEndpoint() {
        response = given()
                .header("app-id", "648b1f2826887a5a2b716dc1")
                .get("https://dummyapi.io/data/v1/user/" + userId);
    }

    @When("I send GET request to the users endpoint")
    public void iSendGETRequestToTheUsersEndpoint() {
        response = given()
                .header("app-id", "648b1f2826887a5a2b716dc1")
                .get("https://dummyapi.io/data/v1/user");
    }

    @When("I send GET request to the tags endpoint")
    public void iSendGETRequestToTheTagsEndpoint() {
        response = given()
                .header("app-id", "648b1f2826887a5a2b716dc1")
                .get("https://dummyapi.io/data/v1/tag");
    }

    @When("I send GET request to the users page endpoint with page {int} and limit {int}")
    public void iSendGETRequestToTheUsersPageEndpoint(int page, int limit) {
        response = given()
                .header("app-id", "648b1f2826887a5a2b716dc1")
                .get("https://dummyapi.io/data/v1/user?page=" + page + "&limit=" + limit);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the user data should contain {string}")
    public void theUserDataShouldContain(String key) {
        Assert.assertTrue(response.jsonPath().getString(key) != null);
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String key) {
        Assert.assertTrue(response.jsonPath().getJsonObject("" + key) != null);
    }
}