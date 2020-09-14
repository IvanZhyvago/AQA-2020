package io.ctdev.juice_shop.sign_up;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class PasswordAdviceValidation {



    private SoftAssert softAssert;
    private static WebDriver driver;
    private String actualResult;
    private String expectedResult1 = "error";
    private String expectedResult2 = "done";
    private String password1 = "QWERTY12!!";
    private String password2 = "qwerty12!!";
    private String password3 = "Qwerty!!";
    private String password4 = "qWErty22";
    private String password5 = "QwE@14";
    private String passwordCorrect = "Qwerty1234!2#";





    @BeforeTest
    public void setUp() {
        softAssert = new SoftAssert();
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
        driver.findElement(By.id("mat-slide-toggle-1")).click();
        System.out.println("Click slider show password advice");

    }

    @AfterTest
    public void afterClass(){
        closeDriver();
    }


    public void passwordAdviceTest (String password) throws InterruptedException {
        driver.findElement(By.id("passwordControl")).sendKeys(password);
        driver.findElement(By.id("passwordControl")).sendKeys(Keys.TAB);
        driver.findElement(By.id("repeatPasswordControl")).sendKeys(password);
        driver.findElement(By.id("repeatPasswordControl")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
    }

    public static void clearValues() {
        driver.findElement(By.id("passwordControl")).clear();
        driver.findElement(By.id("repeatPasswordControl")).clear();
    }

    @Test
    public void passwordAdviceOneLowerCharacterValidation () throws InterruptedException {
        passwordAdviceTest(password1);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
        clearValues();
    }

    @Test
    public void passwordAdviceOneUpperCharacterValidation () throws InterruptedException {
        passwordAdviceTest(password2);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
        clearValues();
    }

    @Test
    public void passwordAdviceOneDigitValidation () throws InterruptedException {
        passwordAdviceTest(password3);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
        clearValues();
    }

    @Test
    public void passwordAdviceOneSpecialValidation () throws InterruptedException {
        passwordAdviceTest(password4);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
        clearValues();
    }

    @Test
    public void passwordEightCharactersValidation () throws InterruptedException {
        passwordAdviceTest(password5);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
        clearValues();
    }

    @Test
    public void passwordCorrectValidation () throws InterruptedException {
        passwordAdviceTest(passwordCorrect);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult, expectedResult2, "Actual result --> " + actualResult);
        softAssert.assertAll();
        clearValues();
    }
}

