package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.cert.X509Certificate;

public class HrAppLoginPage {
    public HrAppLoginPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath ="//button[@class='btn btn-success']" )
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-waring']")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@placeholder='Employee ID..']")
    public WebElement employeeIdSearch;
    @FindBy(id="searchButton")
    public WebElement employeeSearchButton;
    @FindBy(xpath = "(//td)[1]")
    public WebElement employeeID;
    @FindBy(xpath = "(//td)[2]")
    public WebElement employeeFirstName;
    @FindBy(xpath = "(//td)[3]")
    public  WebElement employeeLastName;
    @FindBy(xpath = "(//td)[4]")
    public WebElement employeeDepartmentName;


}
