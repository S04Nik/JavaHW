package com.company.HW05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        try(Scanner scan=new Scanner(System.in)){
            String[]arr={"src/com/company/HW05/tmp.txt","ivan","stepan"};
//            System.out.println("Введите путь к файлу");
//            arr[0]=scan.nextLine();
//            System.out.println("Введите слово для поиска");
//            arr[1]=scan.nextLine();
//            System.out.println("Введите слово для замены");
//            arr[2]=scan.nextLine();
            try(FileInputStream fin=new FileInputStream(arr[0])){
                byte[]buffer=new byte[fin.available()];
                int count=-1;
                String  txt=new String();
                while((count= fin.read(buffer))!=-1)
                {
                    txt=new String(buffer,0,count,"utf-8");
                }
                System.out.println("Количество изменений : "+(txt.split("ivan").length-1));
                txt=txt.replace(arr[1],arr[2]);

                // обратно запись файла
                try(FileOutputStream fos=new FileOutputStream(arr[0]))
                {
                    // перевод строки в байты
                    buffer = txt.getBytes();

                    fos.write(buffer, 0, buffer.length);
                }
                catch(Exception ex){

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");


            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
