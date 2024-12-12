package petStore_CRUD;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PetDelete extends PetStore_URI {
    /*
    Given
       https://petstore.swagger.io/v2/pet/9223372036854775807

    When
        User sends DELETE Request to the URL

    Then
        Status code is 200

     */

    @Test
    public void deletePet (){
        //Set the URL
        Object petId = "9223372036854775807";
        spec.pathParams("first","pet","second",petId);

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(200,actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));
    }
}
