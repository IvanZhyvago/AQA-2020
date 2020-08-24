package io.ctdev.HomeWork2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Task_2 {
    Random random;
    SoftAssert softAssert;
    int a;

    @Test
    public void validateRandomNumbers () {
    a = random.nextInt(20);
    System.out.println(a);
    softAssert.assertTrue(a >= 0 && a <= 10 , " Value not in range 0-10" );
    softAssert.assertAll();
    }

    @BeforeClass
    public void beforeClass () {
        random = new Random ();
        softAssert = new SoftAssert();
    }
}
