package com.company.HW05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
            String[]arr={"src/com/company/HW05/tmp.txt",
                    "src/com/company/HW05/tmp2.txt",
                    "src/com/company/HW05/tmp3.txt"};
            String mainTxt=new String();byte[] buffer=new byte[0];
            for (String item:arr) {

                try(FileInputStream fin=new FileInputStream(item)) {
                    buffer = new byte[fin.available()];
                    int count = -1;
                    String txt = new String();
                    while ((count = fin.read(buffer)) != -1) {
                        txt = new String(buffer, 0, count, "utf-8");
                    }
                    mainTxt=mainTxt.concat(txt);

                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
                System.out.println(mainTxt);
                System.out.println("Bytes length : "+mainTxt.getBytes().length);

                // запись в общий файл
                try(FileOutputStream fos=new FileOutputStream("src/com/company/HW05/tmp_New.txt"))
                {
                    // перевод строки в байты
                    buffer = mainTxt.getBytes();

                    fos.write(buffer, 0, buffer.length);
                }
                catch(Exception ex){

                    System.out.println(ex.getMessage());
                }
                System.out.println("The file has been written");
            }

    }
