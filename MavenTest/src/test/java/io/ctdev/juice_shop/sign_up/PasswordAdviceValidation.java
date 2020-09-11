package io.ctdev.juice_shop.sign_up;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class PasswordAdviceValidation {



    private WebDriver driver;
    private SoftAssert softAssert;
    private AccessToSignUpJuiceShop accessToSignUpJuiceShop;

    private String actualResult;
    private String expectedResult1 = "error";
    //private String expectedResult2 = "done";
    private String password1 = "QWERTY12!!";
    private String password2 = "qwerty12!!";
    private String password3 = "Qwerty!!";
    private String password4 = "qwerty22";
    private String password5 = "QwE@14";





    @BeforeTest
    public void setUp() {
        softAssert = new SoftAssert();
        accessToSignUpJuiceShop = new AccessToSignUpJuiceShop ();
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

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
        Thread.sleep(4000);
    }

    public void clearValues () {
        driver.findElement(By.id("passwordControl")).clear();
        driver.findElement(By.id("repeatPasswordControl")).clear();
    }

    @Test
    public void passwordValidation () throws InterruptedException {

        accessToSignUpJuiceShop.signUpToJuiceShop();
        driver.findElement(By.id("mat-slide-toggle-1")).click();
        System.out.println("Click slider show password advice");
        passwordAdviceTest (password1);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult,expectedResult1,"Actual result --> " + actualResult);
        clearValues ();
        passwordAdviceTest (password2);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult,expectedResult1,"Actual result --> " + actualResult);
        clearValues ();
        passwordAdviceTest (password3);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult,expectedResult1,"Actual result --> " + actualResult);
        clearValues ();
        passwordAdviceTest (password4);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult,expectedResult1,"Actual result --> " + actualResult);
        clearValues ();
        passwordAdviceTest (password5);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon")).getAttribute("innerText");
        softAssert.assertEquals(actualResult,expectedResult1,"Actual result --> " + actualResult);

        softAssert.assertAll();

    }
}
