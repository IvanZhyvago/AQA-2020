package io.ctdev.HomeWork2;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.getDriver;

public class AutoTest {

    SoftAssert softAssert;
    WebDriver driver;
    DesiredCapabilities capabilities;

    String titleCorrect = "Google";
    String titleInCorrect = "Google2";

    @Test
    public void tryTest () throws InterruptedException {
        driver.get("https://google.com.ua");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep (2000);
        softAssert.assertEquals(titleCorrect, driver.getTitle(),"Error1");
        softAssert.assertEquals(titleInCorrect, driver.getTitle(),"Error2");
        softAssert.assertEquals(titleInCorrect, driver.getTitle(),"Error3");
        softAssert.assertEquals(titleInCorrect, driver.getTitle(),"Error4");
        softAssert.assertEquals(titleCorrect, driver.getTitle(), "Error5");
        //Assert.assertEquals(driver.getTitle(), titleCorrect, "errors in title");
        softAssert.assertAll();
    }

    @BeforeTest()
    public void createCapabilities () {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("unexpectedAlertBehavior", false);

    }

    @BeforeClass
    public void createDriver () {

        driver = getDriver();
    }

    @BeforeClass
    public void createSoftAssert() { softAssert = new SoftAssert(); }

    @AfterClass
    public void closeDriver () {
        WebDriverSingleton.closeDriver();
    }

}
