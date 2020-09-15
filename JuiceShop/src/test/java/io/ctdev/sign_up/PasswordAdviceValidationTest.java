package io.ctdev.sign_up;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class PasswordAdviceValidationTest extends SetData {


    private SoftAssert softAssert;
    private String actualResult;
    private String expectedResult1 = "error";
    private String expectedResult2 = "done";
    private String password1 = "QWERTY12!!";
    private String password2 = "qwerty12!!";
    private String password3 = "Qwerty!!";
    private String password4 = "qWErty22";
    private String password5 = "QwE@14";
    private String passwordCorrect = "Qwerty1234!2#";

    private String idPassword = "passwordControl";
    private String idRepeatPassword = "repeatPasswordControl";


    public void passwordAdviceTest(String password) throws InterruptedException {
        driver.findElement(By.id(idPassword)).sendKeys(password);
        driver.findElement(By.id(idPassword)).sendKeys(Keys.TAB);
        driver.findElement(By.id(idRepeatPassword)).sendKeys(password);
        driver.findElement(By.id(idRepeatPassword)).sendKeys(Keys.TAB);
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void clearValues() {
        driver.findElement(By.id("passwordControl")).clear();
        driver.findElement(By.id("repeatPasswordControl")).clear();
    }

    @BeforeClass
    public void openSlide () {
        driver.findElement(By.xpath("//input [contains(@id , 'mat-slide-toggle')]/../../..")).click();
        System.out.println("Click slider show password advice");
    }


    @Test
    public void passwordAdviceOneLowerCharacterValidation () throws InterruptedException {
        passwordAdviceTest(password1);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneUpperCharacterValidation () throws InterruptedException {
        passwordAdviceTest(password2);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one upper character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneDigitValidation () throws InterruptedException {
        passwordAdviceTest(password3);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one digit']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordAdviceOneSpecialValidation () throws InterruptedException {
        passwordAdviceTest(password4);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least one special character']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordEightCharactersValidation () throws InterruptedException {
        passwordAdviceTest(password5);
        actualResult = driver.findElement(By.xpath("//span[text() = 'contains at least 8 characters']/../mat-icon")).getAttribute("innerText");
        Assert.assertEquals(actualResult, expectedResult1, "Actual result --> " + actualResult);
    }

    @Test
    public void passwordCorrectValidation () throws InterruptedException {
        softAssert = new SoftAssert();
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
    }
}
