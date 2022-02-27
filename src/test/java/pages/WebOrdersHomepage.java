package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebOrdersHomepage {
    public WebOrdersHomepage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement ordertab;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr")
    public List<WebElement> numberOfRows;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[2]")
    public WebElement firstNameInRow;

    @FindBy(xpath = "//a[@href='Default.aspx']")
    public WebElement viewAllOrdersModule;


}
