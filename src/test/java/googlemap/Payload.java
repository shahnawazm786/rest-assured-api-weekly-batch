package googlemap;

public class Payload {
    public static String addLocationPaylod(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"KAZ Classes\",\n" +
                "  \"phone_number\": \"(+91) 6789004567\",\n" +
                "  \"address\": \"22, Shaheen Bagh, New Delhi\",\n" +
                "  \"types\": [\n" +
                "    \"Online Classes\",\n" +
                "    \"Academy\"\n" +
                "  ],\n" +
                "  \"website\": \"http://kazonline.com\",\n" +
                "  \"language\": \"India-EN\"\n" +
                "}\n";
    }
}
