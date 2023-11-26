package stepDefination;


import ResponseBody.LocationResponse;
import io.cucumber.java.Before;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pageObjects.AddPlace;
import stepDefination.LocationStepDefinationAPI;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void runBeforeDeletePlaceAPI() throws Exception {
        LocationStepDefinationAPI locationStepDefinationAPI = new LocationStepDefinationAPI();
        if(LocationStepDefinationAPI.placeId==null) {
            AddPlace addPlace = new AddPlace();
            RequestSpecification req = locationStepDefinationAPI.addPlacePayload("Choudhury", "Hindi", "Europe");
            LocationResponse response = addPlace.userCallsAddPlaceAPIWithPostHttpRequest(req, "AddPlaceAPI", "post");
            LocationStepDefinationAPI.placeId = response.getPlace_id();

        }
    }
}
