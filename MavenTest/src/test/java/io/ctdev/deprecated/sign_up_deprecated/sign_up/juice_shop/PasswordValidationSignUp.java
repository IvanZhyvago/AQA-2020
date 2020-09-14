package io.ctdev.deprecated.sign_up_deprecated.sign_up.juice_shop;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class PasswordValidationSignUp {

    private WebDriver driver;
    private SoftAssert softAssert;
    private AccessToSignUpJuiceShop accessToSignUpJuiceShop;

    private String actualResult;
    private String expectedResult1 = "Passwords do not match";
    private String expectedResult2 = "Please provide a password.";
    private String expectedResult3 = "Password must be 5-20 characters long.";
    private String password1 = "";
    private String password2 = "qwer";
    private String password3 = "Qwerty123!12$";





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


    @DataProvider(name = "values for password")
    public Object[] values () {
        ArrayList<String> arrayList = new ArrayList <>();
        arrayList.add(password1);
        arrayList.add(password2);
        arrayList.add(password3);
        return new Object[]{arrayList};
    }

    @Test(dataProvider = "values for password")
    public void passwordValidation (ArrayList<String> passwords) throws InterruptedException {

        accessToSignUpJuiceShop.signUpToJuiceShop();

        for (String i: passwords) {
            driver.findElement(By.id("passwordControl")).sendKeys(i);
            driver.findElement(By.id("passwordControl")).sendKeys(Keys.TAB);
            Thread.sleep(4000);
            if (i.equals("")){
                actualResult = driver.findElement(By.id("mat-error-3")).getText();
                softAssert.assertEquals(actualResult, expectedResult2, "Password validation Fail -> " + i);
            }else if (i.length() < 5 ) {
                actualResult = driver.findElement(By.id("mat-error-7")).getText();
                softAssert.assertEquals(actualResult, expectedResult3, "Password validation Fail -> " + i);
            }
            else {
                driver.findElement(By.id("repeatPasswordControl")).sendKeys("errorPassword");
                driver.findElement(By.id("repeatPasswordControl")).sendKeys(Keys.TAB);
                Thread.sleep(4000);
                actualResult = driver.findElement(By.id("mat-error-8")).getText();
                softAssert.assertEquals(actualResult, expectedResult1, "Password validation Fail -> " + i);
            }
            driver.findElement(By.id("passwordControl")).clear();
            }
        softAssert.assertAll();
        }


    }



