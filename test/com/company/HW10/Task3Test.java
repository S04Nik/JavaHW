package com.company.HW10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {
    Task3 tmp=null;
    @Before
    public void init(){
        tmp=new Task3();
        System.out.println("initialized");
    }
    @Test
    public void polindromCheck() {
        boolean answer=tmp.polindromCheck("doode");
        Assert.assertEquals("Not polindrom",true,answer);
    }

    @Test
    public void countVowel() {
        int count=tmp.countVowel("aaabbb");
        Assert.assertEquals("Not right regEx",3,count);
    }

    @Test
    public void countConsonant() {
        int count=tmp.countConsonant("aaabbb");
        Assert.assertEquals("Not right regEx",3,count);
    }

    @Test
    public void wordCount() {
        int count=tmp.wordCount("Hello world  world","world");
        Assert.assertEquals("Not right check",2,count);
    }
}