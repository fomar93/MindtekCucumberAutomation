/*package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HrAppLoginPage;
import pages.HrAppNewEmployeeMainPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;
import java.util.UUID;

public class HrAppSteps {
    WebDriver driver= Driver.getDriver();
    HrAppLoginPage hrAppLoginPage= new HrAppLoginPage();
    HrAppNewEmployeeMainPage hrAppNewEmployeeMainPage= new HrAppNewEmployeeMainPage();

    private final String firstName = UUID.randomUUID().toString().replace("-", "").substring(0,7);
    private final String lastName = UUID.randomUUID().toString().replace("-", "").substring(0,7);



    @Given("User navigates to HR App {string} page")
    public void user_navigates_to_HR_App_page(String hrAppUrl) {
        driver.get(ConfigReader.getProperty(hrAppUrl));

    }



    @When("user enters {string} for username and {string} for password and clicks login button")
    public void user_enters_for_username_and_for_password_and_clicks_login_button(String username, String password) {
    hrAppLoginPage.username.sendKeys(username);
    hrAppLoginPage.password.sendKeys(password);
    hrAppLoginPage.loginButton.click();
    }
    @Then("user lands on the {string} page where he sees the list of the employees")
    public void user_lands_on_the_page_where_he_sees_the_list_of_the_employees(String mainPageURL) {
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,mainPageURL);

    }


    @Then("{string} message is displayed")
    public void messageIsDisplayed(String errorMessage) {
        String actualErrorMessage=hrAppLoginPage.errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, errorMessage);
    }



    @And("User provides data for the input fields and clicks on SAVE button")
    public void userProvidesDataForTheInputFieldsAndClicksOnSAVEButton() throws InterruptedException {
        hrAppNewEmployeeMainPage.CreateNewEmployeetab.click();
        hrAppNewEmployeeMainPage.firstName.sendKeys(firstName);
        hrAppNewEmployeeMainPage.lastName.sendKeys(lastName);
        Thread.sleep(5000);
        Select select= new Select(hrAppNewEmployeeMainPage.departmentName);
        select.selectByVisibleText("Marketing");
        Thread.sleep(5000);
        Select select2=new Select(hrAppNewEmployeeMainPage.jobTitle);
        select2.selectByVisibleText("Administration Assistant");

        //BrowserUtils.selectDropdownByValue(hrAppNewEmployeeMainPage.departmentName,"20");
       // BrowserUtils.selectDropdownByValue(hrAppNewEmployeeMainPage.jobTitle,"FI_ACCOUNT");
        hrAppNewEmployeeMainPage.salary.clear();
        hrAppNewEmployeeMainPage.salary.sendKeys("50000");
        Thread.sleep(3000);
        hrAppNewEmployeeMainPage.saveButton.click();
        Thread.sleep(3000);
        
    }

    @Then("User validates new employee is created")
    public void userValidatesNewEmployeeIsCreated() {
        for(int i=hrAppNewEmployeeMainPage.firstNames.size()-1;i>=0;i--){
            if(hrAppNewEmployeeMainPage.firstNames.get(i).getText().equals(firstName)){
                Assert.assertEquals(lastName,hrAppNewEmployeeMainPage.lastNames.get(i).getText());
            }
        }


    }
}

 */
