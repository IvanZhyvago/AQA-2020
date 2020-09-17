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
        ArrayList<Integer> arrayList = new ArrayList <>();
        for(int i =0; i<=9; i++){
            arrayList.add(random.nextInt(20)); }
        return new Object[]{arrayList};
        }


    @Test(dataProvider = "provide for AQA")
    public void doSomething (ArrayList<Integer> data) {
        System.out.println("check values:"+ data);
        for (int i : data){
            softAssert.assertTrue(i >= 0 && i <= 10 , " Value not in range 0-10, your value is "+ i );
        }
        softAssert.assertAll();
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
