package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class RequestSpec {
    public static  RequestSpecification requestAddPlace;
        public RequestSpecification requestSpecification() throws IOException {
            if(requestAddPlace==null) {
                PrintStream printstream = new PrintStream(new FileOutputStream("Logger.txt"));
                requestAddPlace = new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(printstream))
                        .addQueryParam("key", "qaclick123").addFilter(ResponseLoggingFilter.logResponseTo(printstream))
                        .build();
                return requestAddPlace;
            }
            return requestAddPlace;
        }
        public String getGlobalProperties(String key) throws IOException {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PriyanjaliChoudhury\\IdeaProjects\\CucumberAPIProject\\src\\main\\java\\resources\\global.properties");
            properties.load(fileInputStream);
            return properties.get(key).toString();

        }
}
