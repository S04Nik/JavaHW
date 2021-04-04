package com.company.HW04;

public class Task2 {
    public static void main(String[] args) {
        Operable op=(a,b)-> System.out.println(Math.max(a,b));
        op.Arithmetic(4,8);
        System.out.println("---------------------------");
        op=(a,b)-> System.out.println(Math.min(a,b));
        op.Arithmetic(4,8);
        System.out.println("---------------------------");
        Operable2 oper=(a)->{
            int factorial=1;
            for(int i=2;i<a;i++)
            {
                factorial*=i;
            }
            System.out.println(factorial);
        };
        oper.Arithmetic(20);
        System.out.println("---------------------------");
        oper=(a)->{
          if(a==1) {
              System.out.println("Not simple");
          }
          boolean answer =true;
              for(int i=2;i<a;i++)
              {
                  if(a%i==0)
                  {
                      System.out.println("Not simple");
                      answer=false;break;
                  }
              }
              if(answer)
              {
                  System.out.println("Simple");
              }
        };
        oper.Arithmetic(15);
    }
    interface Operable{
        void Arithmetic(int a,int b);
    }
    interface Operable2{
        void Arithmetic(int a);
    }
}
