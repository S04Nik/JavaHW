package com.company.HW02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class City {
    public String name;
    public String region;
    public String country;
    private int peopleCount;
    public String postIndex;
    public String phoneCode;
    City(City obj){
        this.name=obj.name;
        this.region=obj.region;
        this.country=obj.country;
        this.peopleCount=obj.peopleCount;
        this.postIndex=obj.postIndex;
        this.phoneCode=obj.phoneCode;
    }
    City(String name,String region,String country,int peopleCount,String postIndex,String phoneCode){
        this.name=name;
        this.region=region;
        this.country=country;
        this.peopleCount=peopleCount;
        this.postIndex=postIndex;
        this.phoneCode=phoneCode;
    }
    City(){
        System.out.println("-- City --");
        SetInfo();
    }
    public int GetPeopleCount(){
        return this.peopleCount;
    }
    public void SetPeopleCount(int c){
        this.peopleCount=c;
    }
    public void  SetInfo(){
        try{
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name=scan.next();
        System.out.println("Enter region: ");
        this.region=scan.next();
        System.out.println("Enter country: ");
        this.country=scan.next();
        System.out.println("Enter number of people: ");
        this.peopleCount=scan.nextInt();
        System.out.println("Enter post index: ");
        this.postIndex=scan.next();
        System.out.println("Enter phone code: ");
        this.phoneCode=scan.next();
        scan.close();
        }catch(InputMismatchException ex)
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public void GetInfo(){
        System.out.println("name:"+this.name);
        System.out.println("region:"+this.region);
        System.out.println("country:"+this.country);
        System.out.println("number of people:"+this.peopleCount);
        System.out.println("post index:"+this.postIndex);
        System.out.println("phone code:"+this.phoneCode);
    }



}
