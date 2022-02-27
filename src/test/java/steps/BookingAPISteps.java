package steps;

import bookingsapipojo.Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingAPISteps {

    Response response;

    @Given("user sends create booking api POST call with data")
    public void user_sends_create_booking_api_POST_call_with_data(io.cucumber.datatable.DataTable dataTable) {

        Map<String, Object> data= dataTable.asMap(String.class,Object.class);
        Booking booking = new Booking();
        booking.setFirstname(data.get("firstName").toString());


        response=
                given().baseUri(ConfigReader.getProperty("BookingAPIBaseURI"))
                        .and().header("Content-Type", "application/json")
                        .and().header("Accept", "application/json")
                        .and().body(booking)//POJO
                        .when().post("/booking");

    }

    @Then("user validates status code {int} for booking")
    public void user_validates_status_code_for_booking(Integer int1) {

    }
    @Then("user validates that booking is created with api get call")
    public void user_validates_that_booking_is_created_with_api_get_call() {

    }
    @When("user updates booking with api Patch call with data")
    public void user_updates_booking_with_api_Patch_call_with_data(io.cucumber.datatable.DataTable dataTable) {

    }


    @When("user deletes booking with api DELETE call")
    public void user_deletes_booking_with_api_DELETE_call() {

    }

    @Then("user validates that booking is deleted and get call has {int} status code")
    public void user_validates_that_booking_is_deleted_and_get_call_has_status_code(Integer int1) {

    }
}
