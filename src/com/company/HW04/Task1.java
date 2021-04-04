package com.company.HW04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task1 {

    public static void main(String[] args) {
        int[]arr={1,2,3};

        Operationable lamb1;
        lamb1=(a,b,c)->a+b+c;
        System.out.println(lamb1.Arithmetic(1,2,3));
        System.out.println("---------------------------");
        lamb1=(a,b,c)->a*b*c;
        System.out.println(lamb1.Arithmetic(1,2,3));
        System.out.println("---------------------------");
        DataTime lamb2=(time)-> System.out.println(time.get(Calendar.HOUR_OF_DAY)+":"+time.get(Calendar.MINUTE));
        lamb2.show(new GregorianCalendar());
        System.out.println("---------------------------");
        lamb2=(time)-> System.out.println(time.get(Calendar.DAY_OF_MONTH)+"/"+time.get(Calendar.MONTH)+"/"+time.get(Calendar.YEAR));
        lamb2.show(new GregorianCalendar());
    }

    interface DataTime{
        void show(Calendar time);
    }

    interface Operationable{
        int Arithmetic(int a, int b, int c);
    }



}