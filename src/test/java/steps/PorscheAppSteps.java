package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.Driver;

public class PorscheAppSteps {
    WebDriver driver= Driver.getDriver();


    @Given("user navigates to Porsche application")
    public void userNavigatesToPorscheApplication() {

        driver.get(ConfigReader.getProperty("PorscheAppURL"));
    }


    @When("user stores the {string} and selects the model {int} Cayman")
    public void userStoresTheAndSelectsTheModelCayman(String arg0, int arg1) {
        driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[1]")).click();
        String price= driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]")).getText();
        System.out.println(price);

    }
    @Then("user validates Base price is matched with listed price")
    public void user_validates_Base_price_is_matched_with_listed_price() {

    }



}
