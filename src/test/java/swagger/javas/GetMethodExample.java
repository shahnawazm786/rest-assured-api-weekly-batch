package swagger.javas;
import static io.restassured.RestAssured.*;
public class GetMethodExample {
    //geven() - request header, query parameter, authentication,
    //when() // methods get(), post(),delete(),update()
    //then() // response -
    public static void main(String[] args) {
    //postMethod();
        postMethodWithResponse();
        getMethod();
    }
    static void getMethod(){
        given().header("Content-Type","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/9223372016900015120")
                .then().
                log().all().
                assertThat().statusCode(200);
    }
    static void postMethod(){
        given().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"German Shepard - Demo\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"Demo\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().assertThat().statusCode(200);

    }
    static void postMethodWithResponse(){
        given().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"German Shepard - Demo\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"Demo\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }
}
