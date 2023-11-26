package stepDefination;

import ResponseBody.AddPlaceResponse;
import ResponseBody.LocationResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pageObjects.AddPlace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class LocationStepDefinationAPI {
    public static String placeId;
    RequestSpecification req;
    LocationResponse response;
    AddPlace addPlace = new AddPlace();
    String Actual;
    @Given("AddPlace payload with {string} {string} and {string}")
    public RequestSpecification addPlacePayload(String name, String language, String address) throws IOException {
        req =  addPlace.addPlaceAPI(name, language, address);
        return req;
    }

    @Given("Delete payload")
    public void deletePayload() throws IOException {
        req = addPlace.deletePlaceAPI(placeId);
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String nameOfAPI, String typeOfHttpMethod) throws Exception {
        response = addPlace.userCallsAddPlaceAPIWithPostHttpRequest(req,nameOfAPI,typeOfHttpMethod);
        if(nameOfAPI.equalsIgnoreCase("AddPlaceAPI")) {
            placeId = response.getPlace_id();
        }
    }

    @Then("The API call is success with response code {int}")
    public void the_api_call_is_success_with_response_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(int1,response.getStatus(), "The status matched with the expected value");
    }

    @Then("{string} in the response body is {string}")
    public void in_the_response_body_is(String key, String expectedValue) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        if(key.equalsIgnoreCase("Status"))
                    Actual = response.getStatus();
        else if (key.equalsIgnoreCase("name"))
                    Actual = response.getName();
        Assert.assertEquals(expectedValue,Actual, "The status matched with the expected value");
    }

    @Given("Get place url")
    public void getPlaceUrl() throws IOException {
        req = addPlace.getPlaceAPI(placeId);
    }
}
