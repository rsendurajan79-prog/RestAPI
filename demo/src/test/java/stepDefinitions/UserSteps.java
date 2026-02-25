package test.java.stepDefinitions;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserSteps {
    private Response response;
    private String baseUri;

    @Given("the API base URI is {string}")
public void the_api_base_uri_is(String st){
        this.baseUri = st;
        }

   @When("I send a GET request to {string}")
public void i_send_a_get_request_to(String endpoint) {
        response =
                given()
                    .header("x-api-key", "reqres_800fda223fd941b4bb1bbc6a810c210b")
                    .baseUri(baseUri)
                    .contentType("application/json")
                    .log().all()
                .when()
                    .get(endpoint);
    }

   @Then("the response status code should be {int}")
public void the_response_status_code_should_be(Integer code) {
        response.then().statusCode(code);
    }

    @Then("the user first name should be {string}")
    public void verifyFirstName(String name) {
        response.then().body("data.first_name", equalTo(name))
                    .body("data.id", notNullValue())
                .log().ifValidationFails();
    }
}