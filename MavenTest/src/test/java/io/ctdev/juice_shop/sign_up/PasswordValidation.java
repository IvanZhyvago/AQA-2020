package io.ctdev.juice_shop.sign_up;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import io.ctdev.deprecated.sign_up_deprecated.sign_up.juice_shop.AccessToSignUpJuiceShop;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class PasswordValidation {
    private WebDriver driver;

    private String actualResult;
    private String expectedResultProvide = "Please provide a password.";
    private String expectedResultCharactersLong = "Password must be 5-20 characters long.";
    private String expectedResultNotMatch = "Passwords do not match";

    private String password1 = " ";
    private String password2 = "qwer";
    private String password3 = "Qwerty123!12$";





    @BeforeTest
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("http://18.217.145.6/");
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
    }

    @AfterTest
    public void afterClass(){
        closeDriver();
    }




    @Test
    public void passwordEmptyValidation () throws InterruptedException {
        driver.findElement(By.id("passwordControl")).sendKeys(password1);
        driver.findElement(By.id("passwordControl")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("passwordControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'passwordControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        Assert.assertEquals(actualResult, expectedResultProvide, "Password validation Fail -> " + password1);
        driver.findElement(By.id("passwordControl")).clear();
    }

    @Test
    public void passwordContainsAtLeastFourCharactersValidation () throws InterruptedException {
        driver.findElement(By.id("passwordControl")).sendKeys(password2);
        driver.findElement(By.id("passwordControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'passwordControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        Assert.assertEquals(actualResult, expectedResultCharactersLong, "Password validation Fail -> " + password2);
        driver.findElement(By.id("passwordControl")).clear();
    }

    @Test
    public void passwordDoNotMatchValidation () throws InterruptedException {
        driver.findElement(By.id("passwordControl")).sendKeys(password2);
        driver.findElement(By.id("passwordControl")).sendKeys(Keys.TAB);
        driver.findElement(By.id("repeatPasswordControl")).sendKeys("errorPassword");
        driver.findElement(By.id("repeatPasswordControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'repeatPasswordControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        Assert.assertEquals(actualResult, expectedResultNotMatch, "Password validation Fail -> " + password3);
        driver.findElement(By.id("repeatPasswordControl")).clear();
        driver.findElement(By.id("passwordControl")).clear();

    }
}
