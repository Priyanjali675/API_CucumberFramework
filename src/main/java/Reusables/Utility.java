package Reusables;

import ResponseBody.AddPlaceResponse;
import io.restassured.path.json.JsonPath;

public class Utility {
    static JsonPath json;
    public static String extractValueFromResponse(String response, String Key){
        json = rawToJson(response);
        String Actual = json.get(Key).toString();
        return Actual;
    }
    public static String formatConversion(AddPlaceResponse response){
        String response_StringFormat = response.toString();
        return response_StringFormat;
    }
    public static JsonPath rawToJson(String response){
        JsonPath js = new JsonPath(response);
        return js;
    }

}
