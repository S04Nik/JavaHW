package com.company.HW04;

public class Task3 {
    public static void main(String[] args) {
        Operable<Integer> op=(a,b,c)->{
            System.out.println(Math.max(c,Math.max(a,b)));
        };
        op.Arithmetic(2,3,4);
        System.out.println("--------------------");
        op=(a,b,c)->{
            System.out.println(Math.min(c,Math.min(a,b)));
        };
        op.Arithmetic(2,3,4);
    }
    interface Operable<T extends Number>{
        void Arithmetic(T a,T b,T c);
    }
}
