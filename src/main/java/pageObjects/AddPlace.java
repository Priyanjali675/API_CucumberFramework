package pageObjects;
import RequestBody.AddPlaceRequest;
import RequestBody.DeletePlaceRequest;
import RequestBody.Location;
import ResponseBody.LocationResponse;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import Reusables.Utility;
import resources.RequestSpec;
import resources.Resources;
import java.io.IOException;

public class AddPlace extends Utility{


    AddPlaceRequest addPlaceRequestBody;
    DeletePlaceRequest deletePlaceRequestBody;
    HttpsMethods httpsMethods;
    RequestSpecification requestAddPace1,requestAddPlace,requestDeletePlace,requestDeletePace1;
    RequestSpec requestspec = new RequestSpec();

    public RequestSpecification addPlaceAPI(String name, String language, String address) throws IOException {

        addPlaceRequestBody =  createAddPlaceRequestBody(name, language, address);
        requestAddPlace= requestspec.requestSpecification();
        requestAddPace1 = given().spec(requestAddPlace).body(addPlaceRequestBody);
        return requestAddPace1;
    }
    public RequestSpecification deletePlaceAPI(String placeId) throws IOException {
        deletePlaceRequestBody = createDeletePlaceRequestBody(placeId);
        requestDeletePlace= requestspec.requestSpecification();
        requestDeletePace1 = given().spec(requestDeletePlace).body(deletePlaceRequestBody);
        return requestDeletePace1;
    }
    public RequestSpecification getPlaceAPI(String placeId) throws IOException {
        requestDeletePlace= requestspec.requestSpecification();
        requestDeletePace1 = given().spec(requestDeletePlace).queryParam("place_id", placeId);
        return requestDeletePace1;
    }
    public LocationResponse userCallsAddPlaceAPIWithPostHttpRequest(RequestSpecification reqSpec, String nameOfAPI, String typeOfHttpMethod) throws Exception {
        httpsMethods= new HttpsMethods();
        String resourcePath = Resources.valueOf(nameOfAPI).getResource();
        return httpsMethods.performHttpOperations(reqSpec, resourcePath,typeOfHttpMethod);
    }

    public  AddPlaceRequest createAddPlaceRequestBody(String Name, String Language, String Address){
        AddPlaceRequest addPlaceRequest = new AddPlaceRequest();
        String[] types = new String[]{"shoe park", "shop"};
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlaceRequest.setName(Name);
        addPlaceRequest.setAddress(Address);
        addPlaceRequest.setPhone_number("(+91) 983 893 3937");
        addPlaceRequest.setAccuracy(50);
        addPlaceRequest.setLocation(location);
        addPlaceRequest.setWebsite("http://google.com");
        addPlaceRequest.setLanguage(Language);
        addPlaceRequest.setTypes(types);
        return addPlaceRequest;
    }
    public DeletePlaceRequest createDeletePlaceRequestBody(String placeId){
        DeletePlaceRequest deletePlaceRequestBody = new DeletePlaceRequest();
        deletePlaceRequestBody.setPlace_id(placeId);
        return deletePlaceRequestBody;
    }
}
