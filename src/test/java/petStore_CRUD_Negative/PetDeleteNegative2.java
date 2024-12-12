package petStore_CRUD_Negative;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PetDeleteNegative2 extends PetStore_URI {
    /*
    Given
       https://petstore.swagger.io/v2/pet/0000000000000000000

    When
        User sends DELETE Request to the URL

    Then
        Status code is 404

     */

    @Test
    public void deletePet (){

        // Delete with Non-Existent Pet Id
        Object nonExistentPetId  = "0000000000000000000";

        //Set the URL

        spec.pathParams("first","pet","second",nonExistentPetId );

        //Send the request and get the response
        Response response = given(spec)
                .delete("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(404,response.statusCode());
        /*
        When testing the DELETE endpoint for a negative scenario, the expected response from the API was not received.
        No error code or message is returned after sending the request.
        Normally it should return a 404 error code. Assert operation cannot be performed because the API is not responding
         */

    }

}
