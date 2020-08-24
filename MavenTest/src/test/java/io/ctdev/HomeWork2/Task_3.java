package io.ctdev.HomeWork2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task_3 {
    SoftAssert softAssert;
    Random random;

    @DataProvider (name = "provide for AQA")
    public Object[] values () {
//        ArrayList<Integer> a = new ArrayList <>();
//        for(int i =0; i<=9; i++){
//            a.add(random.nextInt(20)); }
//  Why don't work :(
        return new Object[]{22,4,23,0,-10,288,4};
        }


    @Test(dataProvider = "provide for AQA")
    public void doSomething (int data) {
        System.out.println("check values:"+ data);
//        softAssert.assertTrue(data >= 0 && data <= 10 , " Value not in range 0-10, your value is "+ data );
//        softAssert.assertAll();
        Assert.assertTrue(data >= 0 && data <= 10 , " Value not in range 0-10, your value is "+ data );
    }

    @BeforeClass
    public void beforeClass(){
        random = new Random ();
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void afterClass(){
        //softAssert.assertAll();
    }
}
