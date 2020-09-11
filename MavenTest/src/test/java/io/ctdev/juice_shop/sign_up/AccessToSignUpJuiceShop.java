package io.ctdev.juice_shop.sign_up;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class AccessToSignUpJuiceShop {

    private WebDriver driver;

        public void signUpToJuiceShop (){
            driver = WebDriverSingleton.getDriver();
            driver.get("http://18.217.145.6/");
            driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.id("navbarAccount")).click();
            System.out.println("Click Account button");
            driver.findElement(By.id("navbarLoginButton")).click();
            System.out.println("Click login button");
            driver.findElement(By.id("newCustomerLink")).click();
            System.out.println("Click register button");
    }
}


