package com.company.HW06;

import java.util.*;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Projector>arr=new ArrayList<Projector>();
        arr.add(new Projector("AA",2018,20,"1"));
        arr.add(new Projector("BB",2019,10,"2"));
        arr.add(new Projector("CC",2020,30,"1"));
        arr.add(new Projector("DD",2021,40,"4"));

        arr.stream()
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .filter(item->item.manufacture.equals("1"))
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .filter(item->item.year== Calendar.getInstance().get(Calendar.YEAR))
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .filter(item->item.price>25)
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .sorted((item1,item2)-> Integer.compare(item1.price, item2.price))
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .sorted((item1,item2)-> item1.price<item2.price?1:item1.price>item2.price?-1:0)
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .sorted((item1,item2)-> Integer.compare(item1.year, item2.year))
                .forEach(Projector::show);
        System.out.println("--------------------");

        arr.stream()
                .sorted((item1,item2)-> item1.year<item2.year?1:item1.year>item2.year?-1:0)
                .forEach(Projector::show);


    }
}

class Projector{
    String name;
    int year;
    int price;
    String manufacture;
    Projector(){}
    Projector(String name,int year,int price,String manufacture){
        this.name=name;
        this.year=year;
        this.price=price;
        this.manufacture=manufacture;
    }
    void show(){
        System.out.println("name : "+name);
        System.out.println("year : "+year);
        System.out.println("price : "+price);
        System.out.println("manufacture : "+manufacture);
    }
}


