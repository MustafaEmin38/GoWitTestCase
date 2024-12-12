package petStore_CRUD_Negative;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class petCreateNegative extends PetStore_URI {
    /*
    Given
    1) https://petstore.swagger.io/v2/pet
    2) {
           "name": 33,
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
    public void createPetNegative(){
        SoftAssert softAssert = new SoftAssert();

        //Set the URL
        spec.pathParam("first","pet");

        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("name",33);//Send integer data, not String
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData=response.as(HashMap.class);

        softAssert.assertEquals(response.statusCode(),404 ,"Expected HTTP code 404 but response 200");
        softAssert.assertEquals(actualData.get("name"),expectedData.get("name"),"Different data or data type ");
        softAssert.assertAll();

    }
}
