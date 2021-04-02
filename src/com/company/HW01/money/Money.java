package com.company.HW01.money;
import java.util.Scanner;

public class Money {
    public int p1_value;
    public int p2_value;
    public String Currency;
    Money(){}
    Money(int vl1,int vl2,String Currency){
        p1_value=vl1;
        p2_value=vl2;
        this.Currency=Currency;
    }
    public void showValue(){
        System.out.println("Value : "+p1_value+","+p2_value);
    }
    public void inputValue(){
        System.out.println("Enter First part of value : ");
        Scanner in = new Scanner(System.in);
        p1_value=in.nextInt();
        System.out.println("Enter Second part of value : ");
        p2_value=in.nextInt();
        in.close();
        System.out.println("Data is saved ! Result : "+p1_value+","+p2_value+" "+Currency);
    }

}
