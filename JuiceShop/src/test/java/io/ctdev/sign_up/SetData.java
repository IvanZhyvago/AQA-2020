package io.ctdev.sign_up;

import io.ctdev.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;


public class SetData {

    protected WebDriver driver;
    protected String webSite = "http://18.217.145.6/";

    @BeforeSuite
    public void setUp () {
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(webSite);
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
    }

    @AfterSuite
    public void afterSuite () {
        WebDriverSingleton.closeDriver();
    }
}
