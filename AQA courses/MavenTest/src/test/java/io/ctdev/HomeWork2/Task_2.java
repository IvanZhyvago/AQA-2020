package io.ctdev.HomeWork2;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Task_2 {
    Random random;
    int randomNumber;

    @Test
    public void validateRandomNumbers () {
    randomNumber = random.nextInt(20);
    System.out.println(randomNumber);
    Assert.assertTrue(randomNumber >= 0 && randomNumber <= 10 , " Value not in range 0-10" );
    }

    @BeforeClass
    public void beforeClass () {
        random = new Random ();
    }
}
