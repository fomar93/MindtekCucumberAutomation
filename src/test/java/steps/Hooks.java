package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        WebDriver driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Before");
    }
    @After
    public void tearDown() throws InterruptedException {
        WebDriver driver=Driver.getDriver();
        Thread.sleep(3000);
        driver.quit();
        System.out.println("After");
    }
}
