package io.ctdev.deprecated.sign_up_deprecated.juice_shop_login_deprecated;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class LoginJuiceShopTest {

    private static WebDriver driver;
    //private SoftAssert softAssert;

    private String userEmail = "ivan.zhyvago@ctdev.io";
    private String userPassword = "Qwerty1234&";
    private String actualResult;

    @BeforeTest
    public void setUp() {
        //softAssert = new SoftAssert();
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterTest
    public void afterClass(){
        closeDriver();
    }

    static void loginToJuiceShop (String email, String password) {
        driver = WebDriverSingleton.getDriver();
        driver.get("http://18.217.145.6/");
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("email")).sendKeys(email);
        System.out.println("Enter Email");
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Enter password");
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Click login button");
    }

    @Test
    public void loginUser () {
        loginToJuiceShop(userEmail,userPassword);
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        actualResult = driver.findElement(By.xpath("//button[@aria-label = 'Go to user profile']//span")).getText();
        //System.out.println(actualResult);
        Assert.assertEquals(actualResult,userEmail,"User is not login");

    }

}

