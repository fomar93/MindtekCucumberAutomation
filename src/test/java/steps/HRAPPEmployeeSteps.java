package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HrAppLoginPage;
import pages.HrAppNewEmployeeMainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HRAPPEmployeeSteps {
    WebDriver driver= Driver.getDriver();
    HrAppLoginPage hrAppLoginPage= new HrAppLoginPage();
    HrAppNewEmployeeMainPage employeeMainPage= new HrAppNewEmployeeMainPage();

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver.get(ConfigReader.getProperty("hrAppUrl"));

        Assert.assertEquals("HrApp",  driver.getTitle());

    }

    @When("user logs in to HR App")
    public void user_logs_in_to_HR_App() throws InterruptedException {
        hrAppLoginPage.username.sendKeys("Mindtek");
        hrAppLoginPage.password.sendKeys("MindtekStudent");
        hrAppLoginPage.loginButton.click();
        Thread.sleep(5000);


    }

    @When("user creates new employee")
    public void user_creates_new_employee() {
        System.out.println("New employee steven was added");


    }

    @Then("user validates new employee is created in Data Base")
    public void user_validates_new_employee_is_created_in_Data_Base() throws SQLException {

        String actualFirstName = employeeMainPage.firstName.getText();

        String actualLastName = employeeMainPage.lastName.getText();

        String actualDepartmentName = employeeMainPage.departmentName.getText();



        String query = "select e.first_name, e.last_name, d.department_name from employees e join departments d on e.department_id = d.department_id\n" +
                "where employee_id=100";
        JDBCUtils.establishConnection();
        List<Map<String,Object>> data = JDBCUtils.runQuery(query);

        Assert.assertEquals(data.get(0).get("first_name"), actualFirstName);
        Assert.assertEquals(data.get(0).get("last_name"), actualLastName);
        Assert.assertEquals(data.get(0).get("department_name"), actualDepartmentName);



    }
}
