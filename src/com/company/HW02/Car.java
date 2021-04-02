package com.company.HW02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Car {
    public String  name;
    private short year;
    public String manufacture;
    private double vEngine;
    Car(String  name,short year,String manufacture,double vEngine){
        this.name=name;
        this.year=year;
        this.manufacture=manufacture;
        this.vEngine=vEngine;
    }
    Car(Car obj){
        this.name=obj.name;
        this.year=obj.year;
        this.manufacture=obj.manufacture;
        this.vEngine=obj.vEngine;
    }
    Car(){
        setInfo();
    }
    public void setInfo(){
        try {
            System.out.println("-- Car --");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter name : ");
            this.name = scan.next();
            System.out.println("Enter year : ");
            this.year = scan.nextShort();
            System.out.println("Enter manufacture : ");
            this.manufacture = scan.next();
            System.out.println("Enter vEngine : ");
            this.vEngine = scan.nextDouble();
        }catch(InputMismatchException ex )
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public void setInfo(Car obj){
        this.name=obj.name;
        this.year=obj.year;
        this.manufacture=obj.manufacture;
        this.vEngine=obj.vEngine;
        this.name=obj.name;
    }
    public void showInfo(){
        System.out.println("name :  "+this.name);
        System.out.println("year : "+this.year);
        System.out.println("manufacture : "+this.manufacture);
        System.out.println("vEngine : "+this.vEngine);
    }
    public void setYear(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter year : ");
        this.year=scan.nextShort();
    }
    public short getYear(){
        return this.year;
    }
    public void setVEngine(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter v of engine : ");
        this.vEngine=scan.nextDouble();
    }
    public double getVEngine(){
        return vEngine;
    }
    public void setYear(short y){
        this.year=y;
    }
    public void setVEngine(double v){
        this.vEngine=v;
    }
    public void Drive()
    {
        System.out.println("Auto pilot turned on . Vehicle is moving");
    }
    public void Drive(Human driver) {
        System.out.println("Driver "+driver.GetName()+" is starting engine . Vehicle is moving");
    }
}
