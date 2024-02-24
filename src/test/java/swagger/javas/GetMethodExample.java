package swagger.javas;
import static io.restassured.RestAssured.*;
public class GetMethodExample {
    //geven() - request header, query parameter, authentication,
    //when() // methods get(), post(),delete(),update()
    //then() // response -
    public static void main(String[] args) {
    //postMethod();
       postMethodWithResponse();
      //  getMethod();
      // postMethodWithResponseAndRequest();
       // updatePet();
      //  deletePet();
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
    static void postMethodWithResponseAndRequest(){
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
                        "}").log().all()
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }

    static void updatePet(){
        given().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 9223372036854251307,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 9223372036854251307,\n" +
                        "    \"name\": \"German Shepard - update demo\"\n" +
                        "  },\n" +
                        "  \"name\": \"computer\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 9223372036854251307,\n" +
                        "      \"name\": \"computer - demo\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().log().all().assertThat().statusCode(200);
    }
    static void deletePet(){
        //9223372036854251307
        given().header("Content-Type","application/json")
                .when().delete("https://petstore.swagger.io/v2/pet/9223372036854251307")
                .then().log().all().assertThat().statusCode(200);
    }
}
