package io.ctdev.deprecated.sign_up_deprecated.sign_up.juice_shop;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
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

public class EmailValidationSignUp {
    private WebDriver driver;

    Actions act;
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
    //private String emailAddress7 = "com@com"; // This bug but works on JuiceShop


    @BeforeTest
    public void setUp() {
        softAssert = new SoftAssert();
        accessToSignUpJuiceShop = new AccessToSignUpJuiceShop ();
        driver = WebDriverSingleton.getDriver();
        act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterTest
    public void afterClass(){
        closeDriver();
    }


    @DataProvider(name = "values for email")
    public Object[] values () {
        ArrayList<String> arrayList = new ArrayList <>();
        arrayList.add(emailAddress1);
        arrayList.add(emailAddress2);
        arrayList.add(emailAddress3);
        arrayList.add(emailAddress4);
        arrayList.add(emailAddress5);
        arrayList.add(emailAddress6);
        //arrayList.add(emailAddress7); real bug
        return new Object[]{arrayList};
    }

    @Test (dataProvider = "values for email")
    public void userIsAbleToSignUp(ArrayList<String> emails) throws InterruptedException {

        accessToSignUpJuiceShop.signUpToJuiceShop();
        for (String i: emails) {
                driver.findElement(By.id("emailControl")).sendKeys(i);
                driver.findElement(By.id("emailControl")).sendKeys(Keys.TAB);
                Thread.sleep(2000);
            if (i.equals("")){
                actualResult = driver.findElement(By.id("mat-error-2")).getText();
                softAssert.assertEquals(actualResult, expectedResult2, "Email validation Fail -> " + i);
            }else {
                actualResult = driver.findElement(By.id("mat-error-7")).getText();
                softAssert.assertEquals(actualResult, expectedResult, "Email validation Fail -> " + i);
            }
                driver.findElement(By.id("emailControl")).clear();
        }
        softAssert.assertAll();

    }
}

