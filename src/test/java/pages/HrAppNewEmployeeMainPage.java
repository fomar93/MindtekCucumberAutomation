package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HrAppNewEmployeeMainPage {
    public HrAppNewEmployeeMainPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/app-root/div[1]/app-employee-details/div[2]/input")
    public WebElement searchBox;

    @FindBy(id = "searchButton")
    public WebElement Search;

    @FindBy(xpath = "//td[2]")
    public WebElement firstName;

    @FindBy(xpath = "//td[3]")
    public WebElement lastName;

    @FindBy(xpath = "//td[4]")
    public WebElement departmentName;

}
/*
    @FindBy(xpath = "//a[@href='/employee/-1']")
    public WebElement CreateNewEmployeetab;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(id = "department")
    public WebElement departmentName;

    @FindBy(id = "job")
    public WebElement jobTitle;

    @FindBy(name = "salary")
    public WebElement salary;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//table[@class='table']//td[2]")
    public List<WebElement> firstNames;


    @FindBy(xpath = "//table[@class='table']//td[3]")
    public List<WebElement> lastNames;

 */


