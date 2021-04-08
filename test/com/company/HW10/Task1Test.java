package com.company.HW10;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class Task1Test {
    Task1 tmp=null;
    @Before
    public void init(){
        tmp=new Task1();
        System.out.println("initialized");
    }

    @Test
    public void menuTest() {

    }

    @Test
    public void squareOfTriangleTest() {
        int res=tmp.squareOfTriangle(2,5,30);
//        if(res>0)
//        {
//            System.out.println("Good");
//
//        }
        Assert.assertEquals("Test error !",-4,res);
    }

    @Test
    public void squareOfRectangleTest() {
        int res=tmp.squareOfRectangle(4,4);
        Assert.assertEquals("Test ERROR",16,res);
    }

    @Test
    public void squareOfRhombusTest() {
        int res= tmp.squareOfRhombus(5,5);
        Assert.assertEquals("TEST ERROR !!!! Expected different value !!!",16,res);
    }
    @After
    public void close(){
        System.out.println("test closed");
    }

}