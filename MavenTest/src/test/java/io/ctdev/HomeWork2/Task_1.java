package io.ctdev.HomeWork2;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.getDriver;

public class Task_1 {

    SoftAssert softAssert;
    WebDriver driver;
    String title = "Customertimes | Salesforce, SAP & Enterprise Technology Consulting & Products";

    @Test
    public void tryTest () throws InterruptedException {
        driver.get("https://customertimes.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.assertEquals(driver.getTitle(),title, "Incorrect Title");
        softAssert.assertAll();
    }

    @BeforeClass
    public void beforeClass () {
        driver = getDriver();
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void afterClass () {
        WebDriverSingleton.closeDriver();
    }
}
