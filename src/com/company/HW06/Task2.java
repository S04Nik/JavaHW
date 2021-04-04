package com.company.HW06;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Device>devices=new ArrayList<Device>();
        devices.add(new Device("MoonS3",1998,50,"green","radio"));
        String colorCheck="green";
        devices.stream()
                .forEach(Device::show);
        System.out.println("--------------------");
        devices.stream()
                .filter(item->item.color.equals(colorCheck))
                .forEach(Device::show);
        System.out.println("--------------------");
        devices.stream()
                .filter(item->item.year==1998)
                .forEach(Device::show);
        System.out.println("--------------------");
        devices.stream()
                .filter(item->item.price>25)
                .forEach(Device::show);
        System.out.println("--------------------");
        devices.stream()
                .filter(item->item.type.equals("radio"))
                .forEach(Device::show);
        System.out.println("--------------------");
        devices.stream()
                .filter(item->item.year>=1998&&item.year<=2010)
                .forEach(Device::show);

    }
}
class Device{
    String name;
    int year;
    int price;
    String color;
    String type;
    Device(){}
    Device( String name, int year,int price, String color,String type)
    {
        this.name=name;
        this.year=year;
        this.price=price;
        this.color=color;
        this.type=type;
    }
    void show(){
        System.out.println("name : "+name);
        System.out.println("year : "+year);
        System.out.println("price : "+price);
        System.out.println("color : "+color);
        System.out.println("type : "+type);

    }
}