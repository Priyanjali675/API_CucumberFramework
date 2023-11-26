package pageObjects;

import ResponseBody.AddPlaceResponse;
import ResponseBody.DeletePlaceResponse;
import ResponseBody.GetPlaceResponse;
import ResponseBody.LocationResponse;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class HttpsMethods {
    ResponseSpecification respSpec;
    public LocationResponse performHttpOperations(RequestSpecification requestAddPlace, String endPoint, String typeOfHttpMethod) throws Exception {
        LocationResponse response = null;
        respSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
        switch(typeOfHttpMethod) {
            case "post":
             response = requestAddPlace.when().post(endPoint).then().spec(respSpec).log().all()
                    .extract().response().as(AddPlaceResponse.class);
             break;
            case "get":
                response = requestAddPlace.when().get(endPoint).then().spec(respSpec).log().all()
                        .extract().response().as(GetPlaceResponse.class);
                break;
            case "delete":
                response = requestAddPlace.when().delete(endPoint).then().spec(respSpec).log().all()
                        .extract().response().as(DeletePlaceResponse.class);
                break;
            default:
                throw new Exception("Invalid option");
        }
        return response;
    }
}
