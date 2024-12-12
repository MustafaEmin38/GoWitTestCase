package petStore_CRUD_Negative;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PetCreateNegative2 extends PetStore_URI {

    /*
    Given
    1) https://petstore.swagger.io/v2/pet
    2) {
           "ankara": "Pamuk",
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
    public void createPet () {
        //Set the URL
        spec.pathParam("first","pet");

        //Set the expected data
        Map <String,Object> expectedData = new HashMap<>();
        expectedData.put("ankara","Pamuk");//Send wrong field in response body
        expectedData.put("status","available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(),404,"Status code must be 404");
        assertTrue("Response body does not contain required field",actualData.containsKey("name"));
        softAssert.assertAll();

        //Note: This negative test did not pass in Intellij, but passed in Postman

    }


}
