package io.ctdev.juice_shop.sign_up;

import io.ctdev.HomeWork2.framework.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static io.ctdev.HomeWork2.framework.driver.WebDriverSingleton.closeDriver;

public class SignUpToJuiceShopTest {

    private WebDriver driver;

    Actions act;
    Random random;


    private String emailStart = "wizdmak+";
    private String emailEnd = "@gmail.com";
    private String password = "Qwerty1234&";
    private String answer = "3777";
    private int randomNumberToLogin;
    private String actualResult;
    private String expectedResult = "Registration completed successfully. You can now log in.";

    @BeforeTest
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        act = new Actions(driver);
        random = new Random();
        randomNumberToLogin = random.nextInt(1000);
        driver.get("http://18.217.145.6/");
        driver.findElement(By.cssSelector("[class*='close-dialog']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterTest
    public void afterClass(){
        closeDriver();
    }

    @Test
    public void userIsAbleToSignUp() throws InterruptedException {
        driver.findElement(By.id("navbarAccount")).click();
        System.out.println("Click Account button");
        driver.findElement(By.id("navbarLoginButton")).click();
        System.out.println("Click login button");
        driver.findElement(By.id("newCustomerLink")).click();
        System.out.println("Click register button");
        driver.findElement(By.id("emailControl")).sendKeys(emailStart+randomNumberToLogin+emailEnd);
        System.out.println("Enter email -> "+ emailStart+randomNumberToLogin+emailEnd);
        driver.findElement(By.id("passwordControl")).sendKeys(password);
        System.out.println("Enter password -> "+ password);
        driver.findElement(By.id("repeatPasswordControl")).sendKeys(password);
        System.out.println("Repeat password -> "+ password);
        driver.findElement(By.id("mat-slide-toggle-1")).click();
        System.out.println("Click slider show password advice");
        act.moveToElement(driver.findElement(By.xpath("//mat-select[@aria-label = 'Selection list for the security question']"))).click().perform();
        //driver.findElement(By.xpath("//mat-select[@id = 'mat-select-1']/div")).click();
        System.out.println("User click to listbox");
        driver.findElement(By.id("mat-option-12")).click();
        System.out.println("Select question");
        driver.findElement(By.id("securityAnswerControl")).sendKeys(answer);
        System.out.println("Enter answer");
        Thread.sleep(2000);
        driver.findElement(By.id("registerButton")).click();
        System.out.println("Click Register");
        actualResult = driver.findElement(By.xpath("//*[contains(text(), 'Registration completed successfully. You can now log in.')]")).getAttribute("innerText");
        Assert.assertEquals(actualResult,expectedResult, "Registration failed");
    }
}
