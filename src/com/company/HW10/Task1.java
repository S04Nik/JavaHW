package com.company.HW10;

import java.util.Scanner;

public class Task1 {
    Task1(){}
    public int menu(){
        try(  Scanner scanner=new Scanner(System.in)){
            int m=4;
            while(m!=0)
            {
                System.out.println("Choose function :");
                System.out.println("1 -  squareOfTriangle ");
                System.out.println("2 - squareOfRectangle ");
                System.out.println("3 - squareOfRhombus ");
                System.out.println("0 - exit ");
                m=scanner.nextInt();
                double a,b,angle;
                switch (m){
                    case 1:
                        System.out.println("enter first side :");
                        a =scanner.nextDouble();
                        System.out.println("enter second side :");
                        b =scanner.nextDouble();
                        System.out.println("enter angle :");
                        angle =scanner.nextDouble();
                        squareOfTriangle(a,b,angle);break;
                    case 2:
                        System.out.println("enter first side :");
                        a =scanner.nextDouble();
                        System.out.println("enter second side :");
                        b =scanner.nextDouble();
                        squareOfRectangle(a,b);break;
                    case 3:
                        System.out.println("enter first side :");
                        a =scanner.nextDouble();
                        System.out.println("enter height to this side :");
                        b =scanner.nextDouble();
                        squareOfRhombus(a,b);break;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return 0;
           }
        return 1;
    }
    public int squareOfTriangle(double a,double b ,double angle){
        double result=0.5*a*b*Math.sin(angle);
        System.out.println("square Of Triangle :"+result);
        return (int)result;
    }
    public int squareOfRectangle(double a,double b){
        double tmp=a*b;
        System.out.println("square Of Rectangle : "+tmp);
        return (int)tmp;
    }
    public int squareOfRhombus(double a,double heightA){
        double tmp=a*heightA;
        System.out.println("square Of Rhombus : "+tmp);
        return (int)tmp;
    }
}
