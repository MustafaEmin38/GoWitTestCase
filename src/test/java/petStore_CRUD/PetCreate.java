package petStore_CRUD;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PetCreate extends PetStore_URI {

    /*
    Given
    1) https://petstore.swagger.io/v2/pet
    2) {
           "name": "Pamuk",
           "status": "available"
        }

        When
           User sends POST Request to the URL
        Then
            Status code 200
        And
            Response body must include "Pamuk"
        And
            Response body must include "available"
     */

    @Test
    public void createPet() {

            //Set the URL
            spec.pathParam("first", "pet");

            //Set the expected data
            Map<String, Object> expectedData = new HashMap<>();
            expectedData.put("name", "Pamuk");
            expectedData.put("status", "available");
            System.out.println("expectedData = " + expectedData);

            //Send the request and get the response
            Response response = given(spec).body(expectedData).post("/{first}");
            response.prettyPrint();

            //Do assertion
            Map<String, Object> actualData = response.as(HashMap.class);
            System.out.println("actualData = " + actualData);

            assertEquals(200, response.statusCode());
            assertEquals(expectedData.get("name"), actualData.get("name"));
            assertEquals(expectedData.get("status"), actualData.get("status"));

        }


    }

