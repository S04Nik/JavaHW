package com.company.HW07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        ArrayList<Integer>arr=new ArrayList<Integer>();
        try(Scanner in=new Scanner(System.in)){
            do {
                System.out.println("Введите STOP для остановки :");
                System.out.println("Введите значение для массива :");
                if(in.hasNextInt())
                arr.add(in.nextInt());
            }while(!in.nextLine().toLowerCase().equals("stop"));

        }catch(Exception ex){
            System.out.println("Exception : "+ex.getMessage());
        }

        Runnable sumNumber=()->{
            int sum= arr.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Sum : "+sum);
        };
        Runnable middleNumber=()->{
            System.out.println("Middle number : "+arr.stream().mapToInt(Integer::intValue).average().getAsDouble());
        };
        Thread first=new Thread(sumNumber,"Sum");
        Thread second=new Thread(middleNumber,"middleNumber");
//        try {
//           Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        first.start();
        second.start();
    }
}
