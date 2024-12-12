package petStore_CRUD_Negative;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import petStore_CRUD.PetCreate;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PetDeleteNegative extends PetStore_URI {
    /*
    Given
       https://petstore.swagger.io/v2/pet/999999999999999999

    When
        User sends DELETE Request to the URL

    Then
        Status code is 404

     */

    @Test
    public void deletePet (){
        //Delete with Empty Pet Id

        //Set the URL
        spec.pathParam("first","pet");

        //Send the request and get the response
        Response response = given(spec)
                .delete("/{first}");
        response.prettyPrint();

        //Do assertion
        assertEquals(405,response.statusCode());
         /*
        When testing the DELETE endpoint for a negative scenario, the expected response from the API was not received.
        No error code or message is returned after sending the request.
        Normally it should return a 405 error code. Assert operation cannot be performed because the API is not responding
         */

    }

}
