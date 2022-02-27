package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomepage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class WebOrderSteps {
    WebDriver driver= Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage= new WebOrdersLoginPage();
    WebOrdersOrderPage webOrdersOrderPage= new WebOrdersOrderPage();
    WebOrdersHomepage webOrdersHomepage= new WebOrdersHomepage();
    int numberofRows;
    List<Map<String,Object>> data;

    @Given("user navigates to the weborders application")
    public void user_navigates_to_the_weborders_application() {

        driver.get(ConfigReader.getProperty("WebOrdersURL"));
    }

    @When("user provides username {string} and password {string} clicks on login button")
    public void user_provides_username_and_password_clicks_on_login_button(String username, String password) {
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();


    }

    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders";

        Assert.assertEquals(expectedTitle,actualTitle);
        driver.quit();

    }
    @Then("user validates error message {string}")
    public void user_validates_error_message_Invalid_Login_or_Password(String errorMessage) {
        String actualErrorMsg=webOrdersLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage, actualErrorMsg);

        driver.quit();




    }
    @And("user clicks on Order module")
    public void userClicksOnOrderModule() {
       webOrdersHomepage.ordertab.click();



    }


    @And("user selects {string} product with {int} quantity")
    public void userSelectsProductWithQuantityQuantity(String product, Integer quantity) {

    }



    @Then("user validates total is calculated correctly for quantity {int}")
    public void userValidatesTotalIsCalculatedCorrectlyForQuantityQuantity(int quantity) {


    }


    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
         data= dataTable.asMaps(String.class,Object.class);
        System.out.println(data.get(0).get("order"));
        BrowserUtils.selectByValue(webOrdersOrderPage.orderProductionDropdown,data.get(0).get("order").toString());
        webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderPage.quantityBox.sendKeys(data.get(0).get("quantity").toString());
        webOrdersOrderPage.name.sendKeys(data.get(0).get("name").toString());
        webOrdersOrderPage.Street.sendKeys(data.get(0).get("street").toString());
        webOrdersOrderPage.city.sendKeys(data.get(0).get("city").toString());
        webOrdersOrderPage.state.sendKeys(data.get(0).get("state").toString());
        webOrdersOrderPage.Zip.sendKeys(data.get(0).get("zip").toString());
        webOrdersOrderPage.visaCheckBox.click();
        webOrdersOrderPage.cardNumber.sendKeys(data.get(0).get("cc").toString());
        webOrdersOrderPage.expireDate.sendKeys(data.get(0).get("expire date").toString());
        webOrdersOrderPage.processButton.click();





    }



    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedmessage) {
        String actualMessage= webOrdersOrderPage.successMessage.getText();
        Assert.assertEquals(expectedmessage, actualMessage);

    }
    @Then("user validates order added to List of Orders")
    public void user_validates_order_added_to_List_of_Orders() {
        webOrdersHomepage.viewAllOrdersModule.click();
        int numberofRowsAfterOrderCreation= webOrdersHomepage.numberOfRows.size();
        Assert.assertEquals(numberofRowsAfterOrderCreation - numberofRows, 1 );
        String actualName= webOrdersHomepage.firstNameInRow.getText();
        Assert.assertEquals(data.get(0).get("name").toString(),actualName);



    }


    @And("user counts number of orders in table")
    public void userCountsNumberOfOrdersInTable() {
        numberofRows= webOrdersHomepage.numberOfRows.size();



    }
}
