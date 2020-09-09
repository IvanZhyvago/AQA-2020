package io.ctdev.HomeWork2;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.getDriver;

public class Task_1 {

    private SoftAssert softAssert;
    WebDriver driver;
    String title = "Customertimes | Salesforce, SAP & Enterprise Technology Consulting & Products";

    @Test
    public void tryTest () throws InterruptedException {
        driver.get("https://customertimes.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebElement selectElement = driver.findElement(By.id("1"));
//        Select selectObject = new Select(selectElement);
//        List<WebElement> allSelectedOptions = selectObject.getAllSelectedOptions();
//        for (WebElement s : allSelectedOptions){
//            System.out.println(s);
//        }
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
