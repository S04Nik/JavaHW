package com.company.HW02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {
    private String name;
    public String author;
    public short year;
    public String publishingOffice;
    public String genre;
    public short pagesNumber;
    Book(String name,String author,short year,String publishingOffice,String genre,short pagesNumber){
        this.name=name;
        this.author=author;
        this.year=year;
        this.publishingOffice=publishingOffice;
        this.genre=genre;
        this.pagesNumber=pagesNumber;
    }
    Book(Book obj) {
    this.name=obj.name;
    this.author=obj.author;
    this.year=obj.year;
    this.publishingOffice=obj.publishingOffice;
    this.genre=obj.genre;
    this.pagesNumber= obj.pagesNumber;

    }
    Book(){
        setInfo();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setInfo(){
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name:");
        this.name=sc.next();
        System.out.println("Enter author:");
        this.author=sc.next();
        System.out.println("Enter year:");
        this.year=sc.nextShort();
        System.out.println("Enter publishingOffice:");
        this.publishingOffice=sc.next();
        System.out.println("Enter genre:");
        this.genre=sc.next();
        System.out.println("Enter pagesNumber:");
        this.pagesNumber=sc.nextShort();}
        catch(InputMismatchException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public void ShowInfo(){
        System.out.println("name :"+this.name);
        System.out.println("author :"+this.author);
        System.out.println("year :"+this.year);
        System.out.println("publishingOffice :"+this.publishingOffice);
        System.out.println("genre :"+this.genre);
        System.out.println("pagesNumber :"+this.pagesNumber);
    }

}
