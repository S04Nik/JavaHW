package com.company.HW01.money;

import java.util.Scanner;

public class Product extends Money {
    public String Name;
    Product(String Name,int vl1,int vl2 , String Currency){
        super(vl1, vl2, Currency);
        this.Name=Name;
    }
    public void DecreaseValue(){
        int a,b;
        System.out.println("Enter number before decimal point : ");
        Scanner in = new Scanner(System.in);
        a=in.nextInt();
        System.out.println("Enter number after decimal point : ");
        b=in.nextInt();
        in.close();
        if(p2_value<b && p1_value>0)
        {
            b-=p2_value;
            p1_value-=1;
            p2_value=(100-b);
        }else
            p2_value-=b;
        p1_value-=a;
        if(p1_value<0)
        {
            p1_value+=1;
            p2_value=100-p2_value;
        }
        System.out.println("Result : "+p1_value+","+p2_value+" "+Currency);
    }
}
