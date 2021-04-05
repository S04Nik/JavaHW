package com.company.HW07;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[]arr=new int[]{1,2,3,4,5,6,7,8,9};
        Runnable min=()->{
            System.out.println(Thread.currentThread().getName()+" Started...");
            System.out.println("Min : "+ Arrays.stream(arr).min().getAsInt());
        };
        Runnable max=()->{
            System.out.println(Thread.currentThread().getName()+" Started...");
            System.out.println("Max :"+ Arrays.stream(arr).max().getAsInt());
        };
        Thread first = new Thread(min,"minimal number");
        Thread second = new Thread(max,"maximal number");
        try {
            first.start();
            second.start();
        }catch(Exception ex){}
    }
}
