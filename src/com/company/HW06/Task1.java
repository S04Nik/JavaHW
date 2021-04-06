package com.company.HW06;

import java.util.Random;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        Random r=new Random();
        int[]arr=new int[r.nextInt(50)];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=r.nextInt(8888);
        }
//        IntStream.of(arr).filter(item->item>0)
//                    .forEach(System.out::println);
//
//        IntStream.of(arr).filter(item->item<0)
//                .forEach(System.out::println);
//
//        IntStream.of(arr).filter(item->item>9||item<-9)
//                .forEach(System.out::println);

//        IntStream.of(arr).filter(i->String.valueOf(i).length()>1)
//                .filter(i->{
//                    String str=String.valueOf(i);
//                    String firstPart=str.substring(0,str.length()/2); // endIndex -1
//                    String reversedPart;
//                    if(String.valueOf(i).length()%2==0)
//                    {
//                         reversedPart=new StringBuilder(str.substring(str.length()/2)).reverse().toString();
//                    }else {
//                         reversedPart=new StringBuilder(str.substring(str.length()/2+1)).reverse().toString();
//                    }
//
//                    return firstPart.equals(reversedPart);
//                })
//                .forEach(System.out::println);



    }
}
