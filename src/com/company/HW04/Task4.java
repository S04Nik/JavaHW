package com.company.HW04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Function;

public class Task4 {

    public static void show(Operationable tmp,Integer a){
        System.out.println("Task4 - show");
        tmp.calc(a);
        System.out.println("----------------------------");
    }
    public static Operationable action(int menu){
        switch (menu){
            case 1:return(number -> {if(number.intValue()%2!=0)
            {
                System.out.println("НЕ четное ");
            }
            });
            case 2:return(number -> {
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // не могу использовать try с ресорсом ->  закрывается system.in
                    int st,fin;
                    System.out.println("Введите 1е число диапазона :");
                    st=Integer.parseInt(reader.readLine());
                    System.out.println("Введите 2е число диапазона :");
                    fin=Integer.parseInt(reader.readLine());
                    if(st<=number.intValue()&&number.intValue()<=fin)
                    {
                        System.out.println("Число в диапазоне ");
                    }
                }catch (Exception ex){}

            });
            case 3:return(number->{
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
                {
                    int tmp;
                    System.out.println("Введите число для проверки кратности :");
                    tmp= Integer.parseInt(reader.readLine());
                    if(number.intValue()% tmp==0)
                    {
                        System.out.println(" Число кратное");
                    }
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            });
            default:return(number-> System.out.println("Something went wrong  with "+number));
        }
    }

}
class Run{
    public static void main(String[] args) {
        Task4.show((a)->{
            if(a.intValue()%2==0)
            {
                System.out.println("Четное число ");
            }
        },2); // четное

        Operationable operationable=Task4.action(1); // не четное
        Task4.show(operationable,5);
        operationable=Task4.action(2); // диапазон
        Task4.show(operationable,5);
        operationable=Task4.action(3); // кратность
        Task4.show(operationable,8);
    }
}
interface Operationable<T extends Number>{
    void calc(T number);
}

