package com.company.HW10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {
    Task2 tmp=null;
    @Before
    public void init(){
        tmp=new Task2();
        System.out.println("initialized");
    }

    @Test
    public void convertToDollars() {
        double res=tmp.convertToDollars(100);
        Assert.assertEquals(ArithmeticException.class,res);
    }

    @Test
    public void convertToEuro() {
        double res=tmp.convertToEuro(100);
        Assert.assertEquals(3.0,res,0.0);
    }

    @Test
    public void convertToFuntSterl() {
        double res=tmp.convertToFuntSterl(100);
        if(res<1)
        {
            Assert.fail();
        }
    }

    @Test(expected = ArithmeticException.class)
    public void convertToYen() {
        double res=tmp.convertToYen(0);

    }
}