package googlemap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class GoogleMapAPIExample {
    Response resp;
    @Test
    public void addLocation(){
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().header("Content-Type","application/json")
                .queryParam("key","qaclick123")
                .log().all()
                .body(Payload.addLocationPaylod())
                .when()
                .put("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat().statusCode(200);


    }

    @Test
    public void addLocationReturnResponse(){
        RestAssured.baseURI="https://rahulshettyacademy.com";
        resp =given().header("Content-Type","application/json")
                .queryParam("key","qaclick123")
                .log().all()
                .body(Payload.addLocationPaylod())
                .when()
                .put("/maps/api/place/add/json")
                .then()
                .extract().response();
        System.out.println(resp); // it will show object reference
        System.out.println("=================== Response in string =============");
        System.out.println(resp.toString());
        System.out.println(String.valueOf(resp));
        System.out.println(resp.getStatusCode());
        System.out.println(resp.getBody());
        System.out.println("=================== Response in string =============");
        System.out.println(resp.asString());

    }
    @Test
    public void addLocationReturnResponseAsString() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String resp = given().header("Content-Type", "application/json")
                .queryParam("key", "qaclick123")
                .log().all()
                .body(Payload.addLocationPaylod())
                .when()
                .put("/maps/api/place/add/json")
                .then()
                .extract().response().asString();
        System.out.println("====================== Response capture in String =========");
        System.out.println(resp);
    }
    @Test(dependsOnMethods = "addLocationReturnResponse")
    public void validateResponseValue(){
        String respString=resp.asString();
        JsonPath path=new JsonPath(respString);
       // int statusCode=path.getInt("statuscode");
        //System.out.println(statusCode);
        String status=path.getString("status");
        System.out.println(status);
        String place_id=path.getString("place_id");
        System.out.println(place_id);
        assertEquals("OK",status);

    }
    @Test
    public void AddLocation1(){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        File file=new File("src/test/resources/location.json");
        String resp = given().header("Content-Type", "application/json")
                .queryParam("key", "qaclick123")
                .log().all()
                .body(file)
                .when()
                .put("/maps/api/place/add/json")
                .then()
                .extract().response().asString();
        System.out.println("====================== Response capture in String =========");
        System.out.println(resp);

        JsonPath path=new JsonPath(resp);
       // System.out.println(path.getString("Content-Type"));
        System.out.println(path.getString("status"));
        System.out.println(path.getString("scope"));
        System.out.println(path.getString("place_id"));
    }

    @Test
    public void AddLocationJSONObject(){
        JSONObject object=new JSONObject();
        object.put("key","qaclick123");
        JSONObject head=new JSONObject();
        head.put("Content-Type","application/json");

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        File file=new File("src/test/resources/location.json");
        String resp = given().header("Contenty-Type",ContentType.JSON)
                .queryParam(object.toString())
                .log().all()
                .body(file)
                .when()
                .put("/maps/api/place/add/json")
                .then()
                .extract().response().asString();
        System.out.println("====================== Response capture in String =========");
        System.out.println(resp);

        JsonPath path=new JsonPath(resp);
        // System.out.println(path.getString("Content-Type"));
        System.out.println(path.getString("status"));
        System.out.println(path.getString("scope"));
        System.out.println(path.getString("place_id"));
    }

//0fe67f47966fc17a90ff6791e8bd0fbf
}
