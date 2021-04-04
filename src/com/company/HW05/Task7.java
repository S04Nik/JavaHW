package com.company.HW05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        try(Scanner scan=new Scanner(System.in)){
            String path="src/com/company/HW05/tmp.txt";
            String []censoredWords={"lemon","apple","cat"};
//                String []censoredWords=new String[0];
//                do{
//                    int i=0;
//                    System.out.println("Введите слово поподающее под цензуру :");
//                    System.out.println("Для Завершения ввода введите final");
//                    if(scan.nextLine()!="final")
//                    {
//                        censoredWords[i]=scan.nextLine();
//                        i++;
//                    }
//                }while(scan.nextLine()!="final");

            try(FileInputStream fin=new FileInputStream(path)){
                byte[]buffer=new byte[fin.available()];
                int count=-1;
                String  txt=new String();
                while((count= fin.read(buffer))!=-1)
                {
                    txt=new String(buffer,0,count,"utf-8");

                }
                for (String item:censoredWords) {
                    System.out.println("Количество изменений для слова "+item+" : "+(txt.split(item).length-1));
                    txt=txt.replace(item,"*****");
                }
                System.out.println(txt);
                // обратно запись файла
                try(FileOutputStream fos=new FileOutputStream(path))
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
