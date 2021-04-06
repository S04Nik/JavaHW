package com.company.HW08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        Set<Integer>arr=new HashSet<>();
        Runnable r=()->{
            Random ran = new Random();
            for(int i=0;i<ran.nextInt(20);i++)
            {
                arr.add(ran.nextInt(50));
            }
            System.out.println("Arr is full of numbers");
        };

        Thread first=new Thread(r, "arrComplete");
        JThread sum=new JThread("SumOfElements");
        JThread aver=new JThread("average");

        first.run();

        try {
            first.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum.run(arr,"sum");
        aver.run(arr,"average");
        System.out.println("Sum : "+sum.tmp);
        System.out.println("Average : "+aver.tmp);
    }
}
class JThread extends Thread {
    public String tmp;
    JThread(String name){
        super(name);
    }

    public void run(Set<Integer>arr,String operation){
        if(operation.equals("sum"))
        {
            int a;
            a=arr.stream().mapToInt(Integer::intValue)
                    .sum();
            tmp=String.valueOf(a);


        }else if(operation.equals("average"))
        {
                tmp=String.valueOf(arr.stream().mapToInt(Integer::intValue)
                        .average().getAsDouble());
        }

    }
}