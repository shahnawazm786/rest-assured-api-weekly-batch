package resreq;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class ResReqExample {
    @BeforeTest
    public void setup(){
        RestAssured.baseURI="https://reqres.in";
    }
    @Test
    public void createUser(){
        JSONObject object=new JSONObject();
        object.put("name","Kaz online");
        object.put("job","faculty");
        int statuscode = given().header("Content-Type", ContentType.JSON)
                .body(object.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .extract().statusCode();
        assertEquals(201,statuscode);
    }
    @Test
    public void createUserRresponseExtract(){
        JSONObject object=new JSONObject();
        object.put("name","Kaz online");
        object.put("job","faculty");
        Response resp = given().header("Content-Type", ContentType.JSON)
                .body(object.toString())
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .extract().response();
        System.out.println(resp.asString());

        JsonPath path=new JsonPath(resp.asString());
        String name=path.getString("name");
        String job=path.getString("job") ;
        int id=path.getInt("id");
        String date=path.getString("createdAt");
        assertEquals("Kaz online",name);
        assertEquals("faculty",job);
        System.out.println("ID : " + id);
        System.out.println("Created Date : "+date);


    }
    @Test
    public void createUserByMapRresponseExtract(){

        Map<String,String> data=new HashMap<>();
        data.put("name","abc appliances");
        data.put("job","business");
        Response resp = given().header("Content-Type",ContentType.JSON)
                .body(data)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .extract().response();
        System.out.println(resp.asString());

        JsonPath path=new JsonPath(resp.asString());
        String name=path.getString("name");
        String job=path.getString("job") ;
        int id=path.getInt("id");
        String date=path.getString("createdAt");
        assertEquals("abc appliances",name);
        assertEquals("business",job);
        System.out.println("ID : " + id);
        System.out.println("Created Date : "+date);


    }
    @Test
    public void createUserByUsingJsonFile(){

        File file= new File("src/test/resources/employee.json");
        Response resp = given().header("Content-Type",ContentType.JSON)
                .body(file).when()
                .post("/api/users")
                .then()
                .log().all()
                .extract().response();
        System.out.println(resp.asString());

        JsonPath path=new JsonPath(resp.asString());
        String name=path.getString("name");
        String job=path.getString("job") ;
        int id=path.getInt("id");
        String date=path.getString("createdAt");
        assertEquals("Coding Maktab",name);
        assertEquals("teaching",job);
        System.out.println("ID : " + id);
        System.out.println("Created Date : "+date);


    }
    @Test
    public void createUserExtractResponseHeader(){

        File file= new File("src/test/resources/employee.json");
        Headers resp = given().header("Content-Type", ContentType.JSON)
                .body(file).when()
                .post("/api/users")
                .then()
//                .log().all()
                .extract().response().getHeaders();
        System.out.println(resp);
        System.out.println();
        System.out.println(resp.get("Date"));

        //JsonPath path=new JsonPath(resp.toString());
        //System.out.println(path.getString("Date"));
        System.out.println(resp.get("Content-Type"));
        String var = resp.get("Content-Type").toString();
        String[] word=var.split("=");
        System.out.println("============================");
        for(String s:word){
            System.out.println(s);
        }

    }
}
