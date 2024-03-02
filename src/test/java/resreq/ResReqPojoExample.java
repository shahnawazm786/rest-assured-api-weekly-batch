package resreq;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Users;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class ResReqPojoExample {
    String PATH_PARAMETER_USER_CREATE_POST_METHOD="/api/users";

    @Test
    public void createUser(){
        Users users=new Users();
        users.setName("KAZ - Classes");
        users.setJob("Computer Training");
        RestAssured.baseURI="https://reqres.in/";
        int status = given().header("Content-Type", ContentType.JSON)
                .body(users)
                .when().post(PATH_PARAMETER_USER_CREATE_POST_METHOD)
                .then().extract().statusCode();
        assertEquals(status,201);
    }
    @Test
    public void createUserExtractResponseInPojoClass(){
        Users users=new Users();
        users.setName("KAZ - Classes");
        users.setJob("Computer Training");
        RestAssured.baseURI="https://reqres.in/";
        Response resp = given().header("Content-Type", ContentType.JSON)
                .body(users)
                .when().post(PATH_PARAMETER_USER_CREATE_POST_METHOD)
                .then().extract().response();
        JsonPath path=new JsonPath(resp.asString());
        users.setId(path.getInt("id"));
        users.setName(path.getString("name"));
        users.setJob(path.getString("job"));
        users.setCreatedAt(path.getString("createdAt"));
        System.out.println(users.getId());
        System.out.println(users.getName());
        System.out.println(users.getJob());
        System.out.println(users.getCreatedAt());
        assertEquals("KAZ - Classes",users.getName());
        assertEquals("Computer Training",users.getJob());
    }
}
