package com.company.HW02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Country {
    public String name;
    public String continent;
    public String capital;
    public String phoneCod;

    Country(Country obj){
        this.name=obj.name;
        this.capital=obj.capital;
        this.continent=obj.continent;
        this.phoneCod=obj.phoneCod;
    }
    Country(String  name,String continent,String capital,String phoneCod){
        this.name=name;
        this.capital=capital;
        this.continent=continent;
        this.phoneCod=phoneCod;
    }
    Country(){
        System.out.println("-- Country --");
        SetInfo();
    }
    public void SetInfo(){
        try{
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter name :");
        this.name=scan.next();
        System.out.println("Enter continent :");
        this.continent=scan.next();
        System.out.println("Enter capital :");
        this.capital=scan.next();
        System.out.println("Enter phone cod :");
        this.phoneCod=scan.next();
        scan.close();
        System.out.println("--DONE--");
        }catch(
        InputMismatchException ex )
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public void GetInfo(){
        System.out.println("name : "+this.name);
        System.out.println("continent : "+this.continent);
        System.out.println("capital : "+this.capital);
        System.out.println("phoneCod : "+this.phoneCod);
    }
}
