package mock;

import io.restassured.path.json.JsonPath;

import java.io.*;

public class MockDataReading {
    public static void main(String[] args) throws IOException {
        JsonPath path=new JsonPath(MockDataPayload.getMockData());
        System.out.println(path.getString("page"));
        System.out.println(path.getString("data[0].first_name"));
        System.out.println(path.getString("support.text"));
        System.out.println(path.getString("support.url"));
    }
}
