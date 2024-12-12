package petStore_CRUD;

import base_uri.PetStore_URI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetGet  extends PetStore_URI{

    /*
    Given
        https://petstore.swagger.io/v2/pet/9223372036854775807

    When
        User sends a GET Request to the URl

    Then
        HTTP Status Code should be 200

    And
        Content Type should be "application/json"

    And
        Status Line should be "HTTP/1.1 200 OK"

     */

    @Test
    public void getPet(){
        //Set the URL
        Object petId = "9223372036854775807";
        spec.pathParams("first","pet","second",petId);


        //Send the request and get the response
        Response response = given(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

    }



}
