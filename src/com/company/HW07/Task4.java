package com.company.HW07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String searched = null;String path="src/com/company/HW07/task4Txt.txt";
        try(Scanner scan=new Scanner(System.in))
        {
            System.out.println("Введите слово для поиска : ");
            searched=scan.next();

        }catch(Exception ex){
            System.out.println("Exception : "+ex.getMessage());
        }
        String finalSearched = searched;
        Runnable r=()->{
            try(FileInputStream getTxt=new FileInputStream(path)) {
                int iterator=-1; String text=null;
                byte[]buffer=new byte[getTxt.available()];
                while((iterator= getTxt.read(buffer))!=-1)
                {
                    text=new String(buffer,0,iterator,"utf-8");
                }
                if(text!=null)
                {
                    if(text.contains(finalSearched));
                    {
                        System.out.println("File contains your word");
                    }if(!text.contains(finalSearched)){
                        System.out.println("No such word in the file");
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(r,"wordSearch").start();
    }
}
