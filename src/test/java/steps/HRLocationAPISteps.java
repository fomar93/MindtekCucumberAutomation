package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.hrapipojos.Department;
import pojos.hrapipojos.Location;
import utilities.ConfigReader;

import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HRLocationAPISteps {
    Response response;
    Integer locationId;


  @Given("User post location api call with data")
    public void user_post_location_api_call_with_data(io.cucumber.datatable.DataTable dataTable) {


      Random random = new Random();
      locationId = random.nextInt();

      Location location = new Location();
      location.setLocationCity("chicago");
      location.setLocationCountry("US");
      location.setLocationId(locationId);
      location.setLocationState("IL");



      response = given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
              .and().header("Content-Type", "application/json")
              .and().body(location)
              .when().post("/api/location");


  }

   @Then("User validates {int} status code")
    public void user_validates_status_code(Integer expectedStatuscode) {
     response.then().statusCode(expectedStatuscode);



    }
    @When("User sends get location api call with created locationId")
    public void user_sends_get_location_api_call_with_created_locationId() {

        response= given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
                .and().header("Accept", "application/json")
                .when().get("/api/location/"+locationId);



    }



    @When("User sends delete location api call with created locationId")
    public void user_sends_delete_location_api_call_with_created_locationId() {

      response= given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
              .when().delete("/api/location/" +locationId);

        System.out.println(response.statusCode());



    }






}




