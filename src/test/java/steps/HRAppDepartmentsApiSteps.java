package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import pojos.hrapipojos.Department;
import pojos.hrapipojos.Location;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class HRAppDepartmentsApiSteps {

    Response response;
    Integer departmentId;

    @Given("User creates department with department post call having data")
    public void user_creates_department_with_department_post_call_having_data() {

        Department departmentBody = new Department();
        Random random = new Random();
        Integer departmentId = random.nextInt();

        departmentBody.setDepartmentId(departmentId);
        departmentBody.setDepartmentName("Fatima"+departmentId);
        Location location = new Location();
        location.setLocationCity("chicago");
        location.setLocationCountry("US");
        location.setLocationId(123);
        location.setLocationState("IL");
        departmentBody.setLocation(location);


                response = given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
                .and().header("Content-Type", "application/json")
                .and().body(departmentBody)
                .when().post("/api/departments");


    }

    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer expectedStatuscode) {
        response.then().statusCode(expectedStatuscode);

    }
    @When("User gets created department")
    public void user_gets_created_department() {

        response =
                given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
                        .and().header("Accept", "application/json")
                        .when().get("/api/department/" +departmentId);


    }

    @Then("User validates created department in Departments dropdown")
    public void user_validates_created_department_in_Departments_dropdown() {
        BrowserUtils.selectByValue(Driver.getDriver().findElement(By.id("department")), departmentId.toString());
        Driver.getDriver().findElement(By.xpath("//options[@value ='"+departmentId+"']")).getText();
        //Assert.assertEquals("Fatima"+departmentId, uiDepartment);



    }
    @When("user deletes created department")
    public void user_deletes_created_department() {
        response =
                given().baseUri(ConfigReader.getProperty("HrAppAPIBaseURI"))
                        .when().delete("/api/departments/" +departmentId);


    }


}
