package com.nopcommerce.demo.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Jay
 */
public class TestNGRetryFailedDemo {

    @Test
    public void test1(){
        System.out.println("I am in test1");
    }

    @Test
    public void test2(){
        System.out.println("I am in test2");
//        int i =1/0;
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test3(){
        System.out.println("I am in test3");
        Assert.assertTrue(true);
    }
}
