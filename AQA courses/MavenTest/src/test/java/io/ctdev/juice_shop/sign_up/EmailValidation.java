package io.ctdev.juice_shop.sign_up;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import io.ctdev.deprecated.sign_up_deprecated.sign_up.juice_shop.AccessToSignUpJuiceShop;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class EmailValidation {

    private WebDriver driver;

    SoftAssert softAssert;
    AccessToSignUpJuiceShop accessToSignUpJuiceShop;

    private String actualResult;
    private String expectedResult = "Email address is not valid.";
    private String expectedResult2 = "Please provide an email address.";
    private String emailAddress1 = "";
    private String emailAddress2 = "@gmail.com";
    private String emailAddress3 = "Иван@gmail.com";
    private String emailAddress4 = "smth@@rambler.ru";
    private String emailAddress5 = "sa_*212!^&*)@aa.com";
    private String emailAddress6 = "wizdmak";
    private String emailAddress7 = "com@com"; // This bug but works on JuiceShop


    @BeforeTest
    public void setUp() {
        softAssert = new SoftAssert();
        accessToSignUpJuiceShop = new AccessToSignUpJuiceShop ();
        driver = WebDriverSingleton.getDriver();
        System.out.println(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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


    @Test()
    public void checkEmptyEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress1);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + emailAddress1);
        driver.findElement(By.id("emailControl")).clear();
    }

    @Test()
    public void checkOnlyRightPartEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress2);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + emailAddress2);
        driver.findElement(By.id("emailControl")).clear();
    }

    @Test()
    public void checkDoubleAtEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress4);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + emailAddress3);
        driver.findElement(By.id("emailControl")).clear();
    }

    @Test()
    public void checkSpecialSymbolsEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress5);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + emailAddress3);
        driver.findElement(By.id("emailControl")).clear();
    }

    @Test()
    public void checkOnlyFirstPartEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress6);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + emailAddress3);
        driver.findElement(By.id("emailControl")).clear();
    }

    @Test()
    public void checkWithoutDotEmailValidation() throws InterruptedException {
        driver.findElement(By.id("emailControl")).sendKeys(emailAddress7);
        driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        actualResult = driver.findElement(By.xpath("//input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error")).getText();
        softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + emailAddress3);
        driver.findElement(By.id("emailControl")).clear();
    }


}

