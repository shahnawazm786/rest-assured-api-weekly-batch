package apispom;

import static io.restassured.RestAssured.*;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import path.IPathPAram;

import pojo.UserListResponseClass;

public class GetMethodAPI {
    RestAssured restAssured;
    Response resp;
    public GetMethodAPI(RestAssured restAssured){
        this.restAssured=restAssured;
    }
    public Response getMethod(int id){
        resp= given().header("Content-Type", ContentType.JSON)
                .when()
                .get(IPathPAram.GET_PARAM_SINGLE_USER)
                .then().extract().response();
        JsonPath path=new JsonPath(resp.asString());
        UserDetails details=new UserDetails();
        details.setId(path.getInt("id"));


        if(resp.getStatusCode()==200){
            return resp;
        }
        return resp;

    }

}
