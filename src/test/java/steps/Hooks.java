package steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    public static RestAssured restAssured;
    @Before
    public void setup(){
        restAssured.baseURI="https://reqres.in/";
    }
}
