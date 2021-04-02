package com.company.HW03;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Task1 {

    public ArrayList<String> MyArray=new ArrayList<String>();
    public  int menuItem;
    public void Menu( Scanner in ){
        do{
        System.out.println("Введите цифру для перехода на функцию : ");
        System.out.println("1 : Add");
        System.out.println("2 : Delete");
        System.out.println("3 : ShowAll");
        System.out.println("4 : ShowItem");
        System.out.println("5 : ChangeItem");
        System.out.println("0 : Exit");
        menuItem=in.nextInt();
        try{
            switch (menuItem){
                case 1:Add(in);break;
                case 2:Delete(in);break;
                case 3:ShowAll();break;
                case 4:ShowItem(in);break;
                case 5:ChangeItem(in);break;
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

        System.out.println("Добавить элемент в список : ");
        try {
            MyArray.add(in.next());
            System.out.println("-- DONE --");
        }catch(Exception ex){
            System.out.println("Add : "+ex.getMessage());
        }
    }

    public void Delete(Scanner in) {
        System.out.println("Удалить элемент из списка - 1 ");
        System.out.println("Удалить элемент из списка по ID  - 2 ");
        try {
            if(in.next()=="1")
            {
                int tmpIndx=MyArray.indexOf(in.next());
                MyArray.remove(tmpIndx);
                System.out.println("-- DONE --");

            }else if(in.nextInt()==2)
            {
                MyArray.remove(in.next());
                System.out.println("-- DONE --");
            }
            Pause();
        }catch(Exception ex){}
    }

    public void ShowAll() {
//     MyArray.forEach(item-> System.out.println(item));
        for (int i=0;i<MyArray.size();i++){
            System.out.println(i+" "+ MyArray.get(i));
        }
        Pause();
    }

    public void ShowItem(Scanner in) {

        System.out.println("Проверить значение в списке :");
        try {
            if(MyArray.contains(in.next()))
            {
                System.out.println("Значение ЕСТЬ в списке ! ");
            }else {
                System.out.println("Значение НЕ в списке ! ");
            }
            Pause();
        }catch(Exception ex){}

    }

    public void ChangeItem(Scanner in) {

        System.out.println("Какой елемент списка изменить ? (Id) :");
        try{
            int tmpIndex=in.nextInt();
            System.out.println("Введите новое значение елемента :");
            String tmpValue = in.next();
            MyArray.set(tmpIndex,tmpValue);

            Pause();
        }catch(Exception ex){

        }


    }
}
