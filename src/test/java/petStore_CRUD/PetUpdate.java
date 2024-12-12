package petStore_CRUD;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PetUpdate extends PetStore_URI {

    /*
    Given
    1) https://petstore.swagger.io/v2/pet
    2) {
           "name": "Minnos",
           "status": "available"
        }

        When
           User sends PUT Request to the URL
        Then
            Status code 200

     */

    @Test
    public void putPet(){
        //Set the URL
        spec.pathParam("first","pet");

        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("name","Minnos");
        expectedData.put("status","available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("status"),actualData.get("status"));



    }


}
