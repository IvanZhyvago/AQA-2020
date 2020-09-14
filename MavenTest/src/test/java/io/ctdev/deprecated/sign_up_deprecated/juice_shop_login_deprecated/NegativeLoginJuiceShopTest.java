package io.ctdev.deprecated.sign_up_deprecated.juice_shop_login_deprecated;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class NegativeLoginJuiceShopTest {


    private static WebDriver driver;
    private static SoftAssert softAssert;
    private String userEmail1 = "";
    private String userPassword1 = "";
    private String userEmail2 = "ivan.zhyvago";
    private String userPassword2 = "Qwerty1234&";
    private String userEmail3 = "ivan.zhyvago@ctdev.io";
    private String userPassword3 = "Qwerty12&";

    private String actualResult;
    private String expectedResult = "true";

    static void clearValues(){
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
    }

    static void repeatLogin(String email, String password){
        clearValues();
        driver.findElement(By.id("email")).sendKeys(email);
        System.out.println("Enter Email");
        driver.findElement(By.id("password")).sendKeys(password);
        System.out.println("Enter password");
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Click login button");

    }



    @BeforeTest
    static void dataSetUp() {
        driver = WebDriverSingleton.getDriver();
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterClass() {
        closeDriver();
    }


    @Test
    public void negativeLogin() {
        LoginJuiceShopTest.loginToJuiceShop(userEmail1,userPassword1);
        actualResult = driver.findElement(By.id("loginButton")).getAttribute("disabled");
        System.out.println(actualResult);
        softAssert.assertEquals(actualResult,expectedResult,"Can login with incorrect values");

        repeatLogin(userEmail2,userPassword2);
        actualResult = driver.findElement(By.id("loginButton")).getAttribute("disabled");
        softAssert.assertEquals(actualResult,expectedResult,"Can login with incorrect values");

        repeatLogin(userEmail3,userPassword3);
        actualResult = driver.findElement(By.id("loginButton")).getAttribute("disabled");
        softAssert.assertEquals(actualResult,expectedResult,"Can login with incorrect values");

        softAssert.assertAll();

    }
}