package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;
import java.util.List;

public class EtsyAppSteps {
    WebDriver driver= Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage= new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage=new EtsyAppSearchPage();

    @Given("user navigates to Etsy application")
    public void user_navigates_to_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }

    @When("user searched for {string}")
    public void user_searched_for(String item) {
        etsyAppHomePage.searchBox.sendKeys(item+ Keys.ENTER);


    }
    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        etsyAppSearchPage.allFilter.click();
        etsyAppSearchPage.priceFilter.click();
        etsyAppSearchPage.applyButton.click();


    }

    @Then("user validates that item prices are over {int}")
    public void user_validates_that_item_prices_are_over(Integer price) throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> prices= etsyAppSearchPage.prices;

        for(WebElement element: prices){
            System.out.println(element.getText());
            String priceStr=element.getText().replace(",", "");
            double doublePrice= Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice>=price);
        }
    }

    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {
        if (section.equalsIgnoreCase("Jewelry and Accessories")){
            etsyAppHomePage.JewelryAndAccessories.click();
        }else if(section.equalsIgnoreCase("End of Year Sales Event")){
            etsyAppHomePage.endOfYearSalesEvent.click();
        }else if(section.equalsIgnoreCase("Clothing and Shoes")){
            etsyAppHomePage.clothingAndShoes.click();
        }else if (section.equalsIgnoreCase("Home and Living")){
            etsyAppHomePage.HomeAndLiving.click();
        }else if (section.equalsIgnoreCase("Wedding and Party")){
            etsyAppHomePage.WeddingAndParty.click();
        }else if(section.equalsIgnoreCase("Toys and Entertainment")){
            etsyAppHomePage.toysAndEntertainment.click();
        }else if(section.equalsIgnoreCase("Art and Collectibles")){
            etsyAppHomePage.ArtAndCollectibles.click();
        }else if(section.equalsIgnoreCase("Craft Supplies and Tools")){
            etsyAppHomePage.craftSupplies.click();
        }else if (section.equalsIgnoreCase("Gifts and Gift Cards")){
            etsyAppHomePage.GiftCards.click();
        }

        
    }

    @Then("user validate title is {string}")
    public void userValidateTitleIs(String expectedTitle) {
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("user validate search results items contain keyword {string}")
    public void userValidateSearchResultsItemsContainKeyword(String item) {
    }
}
