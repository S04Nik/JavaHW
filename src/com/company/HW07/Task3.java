package com.company.HW07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Task3 {
    public static void main(String[] args) {
        String pathFIle="src/com/company/HW07/numbers.txt";
        new JThread("evenThread").run("src/com/company/HW07/evenNumbers.txt","even");
        new JThread("evenThread").run("src/com/company/HW07/oddNumbers.txt","odd");
    }
}
class JThread extends Thread {

    JThread(String name){
        super(name);
    }

    public void run(String path,String method){
        try ( FileInputStream getTxt = new FileInputStream("src/com/company/HW07/numbers.txt");
              FileOutputStream writeFile = new FileOutputStream(path)){
            byte[] buffer = new byte[getTxt.available()]; // количество байт
            int countBytes=-1; String text = null;
            while((countBytes=getTxt.read(buffer))!=-1)
            {
                text=new String(buffer,0,countBytes, StandardCharsets.UTF_8);
            }
            String newText="";
            if (text != null) {
                for(int i=0;i<text.length();i++)
                    if(method.equals("even")&&(int)text.charAt(i)%2==0)
                    {
                        newText+=text.charAt(i);
                    }else if(method.equals("odd")&&(int)text.charAt(i)%2!=0){
                        newText+=text.charAt(i);
                    }
            }
            System.out.println(newText);
            buffer=newText.getBytes(StandardCharsets.UTF_8);
            writeFile.write(buffer,0,buffer.length);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}