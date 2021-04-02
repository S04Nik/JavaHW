package com.company.HW03;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public Map<String,String>MyArray=new HashMap<>();
    public int menuItem;

    Task2(){
        MyArray.put("stepan","123");
        MyArray.put("alex","12345678");
    }

    public void Menu(Scanner in){
        do{
            System.out.println("Введите цифру для перехода на функцию : ");
            System.out.println("1 : Add");
            System.out.println("2 : Delete");
            System.out.println("3 : Check existence");
            System.out.println("4 : Change Login");
            System.out.println("5 : Change Password");
            System.out.println("0 : Exit");
            menuItem=in.nextInt();
            try{
                switch (menuItem){
                    case 1:Add(in);break;
                    case 2:Delete(in);break;
                    case 3:CheckExistence(in);break;
                    case 4:ChangeLogin(in);break;
                    case 5:ChangePassword(in);break;
                    case 0:break;
                }
            }catch(Exception ex){
                System.out.println("MENU ERROR");
                System.out.println(ex.getMessage());
            }
        }while(menuItem!=0);
    }

    public void Pause(){
        int delay = 5000; // number of milliseconds to sleep

        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - delay); // do nothing
    }

    public void Add(Scanner in) {
        try {
            System.out.println("Добавить логин в список : ");
            String login=in.next();
            System.out.println("Добавить пароль в список : ");
            String password=in.next();
            if(MyArray.putIfAbsent(login,password)==null)
            {
                System.out.println("-- DONE --");
            }else{ System.out.println("-- ALREADY EXISTS --");}

        }catch(Exception ex){
            System.out.println("Add : "+ex.getMessage());
        }
    }

    public void Delete(Scanner in) {
        try {
            System.out.println("Введите логин пользователя который будет удален : ");
            String login=in.next();
            MyArray.remove(login);
            System.out.println("-- DONE --");
        }catch(Exception ex){
            System.out.println("Delete : "+ex.getMessage());
        }
    }

    public void CheckExistence(Scanner in) {
        try {
            System.out.println("Введите логин для проверки : ");
            String login=in.next();

            if(MyArray.containsKey(login))
            {
                System.out.println(" Логин существует");
            }else { System.out.println(" Логин  НЕ существует");}

            System.out.println("-- DONE --");
        }catch(Exception ex){
            System.out.println("Delete : "+ex.getMessage());
        }

    }

    public void ChangeLogin(Scanner in) { // LOGIN = KEY -> FINAL
        try{
            System.out.println("Введите старый логин : ");
            String oldLogin=in.next();
            String value=MyArray.get(oldLogin);
            System.out.println("Введите новый логин : ");
            MyArray.put(in.next(),value);
            MyArray.remove(oldLogin);
            System.out.println("-- DONE --");

        }catch(Exception ex){
            System.out.println("-- Error at Changing --");
            System.out.println(ex.getMessage());
        }

    }

    public void ChangePassword(Scanner in) {
        try{
            System.out.println("Введите логин : ");
            String login=in.next();
            System.out.println("Введите новый пароль : ");
            MyArray.put(login,in.next());
            System.out.println("-- DONE --");

        }catch(Exception ex){
            System.out.println("-- Error at Changing --");
            System.out.println(ex.getMessage());
        }
    }
}
