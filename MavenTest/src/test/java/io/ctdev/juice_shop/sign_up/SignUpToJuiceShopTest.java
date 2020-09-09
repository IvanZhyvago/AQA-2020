package io.ctdev.juice_shop.sign_up;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;
import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.getDriver;

public class SignUpToJuiceShopTest {

    private String email = "ivan.zhvago@ctdev.io";
    private String password = "Qwerty1234&";
    private String answer = "3777";

    @BeforeTest
    public void setUp() {
        getDriver().get("http://18.217.145.6/");
        getDriver().findElement(By.cssSelector("[class*='close-dialog']")).click();
    }

    @AfterTest
    public void afterClass(){
        closeDriver();
    }

    @Test
    public void userIsAbleToSignUp() {
        Actions act =  new Actions(getDriver());

        System.out.println("Close navbar");
        getDriver().findElement(By.id("navbarAccount")).click();
        System.out.println("Click login button");
        getDriver().findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        getDriver().findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
        getDriver().findElement(By.id("emailControl")).sendKeys(email);
        System.out.println("Enter email -> "+ email);
        getDriver().findElement(By.id("passwordControl")).sendKeys(password);
        System.out.println("Enter password -> "+ password);
        getDriver().findElement(By.id("repeatPasswordControl")).sendKeys(password);
        System.out.println("Repeat password -> "+ password);
        getDriver().findElement(By.id("mat-slide-toggle-1")).click();
        System.out.println("Click slider show password advice");
        //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        act.moveToElement(getDriver().findElement(By.id("mat-select-1"))).click().perform();
        System.out.println("User try click to listbox");
        //act.moveToElement(getDriver().findElement(By.id("mat-select-1"))).click().perform();
        //getDriver().findElement(By.xpath("//mat-select[@id = 'mat-select-1']/div")).click();
        //getDriver().findElement(By.id("mat-option-12")).click();
        while(getDriver().findElements(By.id("mat-option-12")).size()==0){
            System.out.println("in while");
            getDriver().findElement(By.xpath("//mat-select[@id = 'mat-select-1']/div")).click();
        }
        getDriver().findElement(By.id("mat-option-12")).click();
        System.out.println("Try to find questions");
        //act.moveToElement(getDriver().findElement(By.id("mat-select-15"))).click().perform();
        System.out.println("2");
        getDriver().findElement(By.id("securityAnswerControl")).sendKeys(answer);
        getDriver().findElement(By.id("registerButton")).click();










    }


}
