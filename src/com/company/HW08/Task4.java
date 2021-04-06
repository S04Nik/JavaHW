package com.company.HW08;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        String directory="src/com/company/HW08";
        File dir = new File(directory);
        File[] files = dir.listFiles((dir1, name)->name.endsWith(".txt")); // obj with path to the file
        CommonTxt commontxt=new CommonTxt("");
        Thread first=new FirstThread("merging files",commontxt,files);
        first.run();
        first.join();
        Thread second=new SecondThread("deleting words from file",commontxt);
        second.run();

    }
}
class CommonTxt{
    String txt;
    CommonTxt(String t){
        txt=t;
    }
}
class FirstThread extends Thread{
    public CommonTxt txt;
    public File[]files;
    FirstThread(String name,CommonTxt text,File[]files){
        super(name);
        this.files=files;
        this.txt=text;
    }
    public void run() {
        for (File path:files) {
            if(path.length()>0) // проверяем или файл пустой
            {try(FileInputStream reader = new FileInputStream(path.getPath());
                 FileOutputStream writer = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\first\\src\\mergedFile.txt",true))
            {
                int iterator=-1;
                byte[] buffer=new byte[reader.available()];
                while((iterator=reader.read(buffer))!=-1)
                {
                    txt.txt+=new String(buffer,0,iterator,"utf-8");
                }
                writer.write(txt.txt.getBytes(StandardCharsets.UTF_8),0,buffer.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }else{continue;}

        }
    }

}
class SecondThread extends Thread{
    public CommonTxt commontxt;
    SecondThread(String name,CommonTxt text){
        super(name);
        this.commontxt=text;
    }

    public void run() {
        try(FileInputStream reader = new FileInputStream("src/censoredWords.txt");
            FileOutputStream writer = new FileOutputStream("src/mergedFile.txt",false))
        {
            System.out.println(commontxt.txt);
            int counter=-1;
            byte[]buffer=new byte[reader.available()];
            String tmp="";
            while((counter=reader.read(buffer))!=-1){
                tmp=new String(buffer,0,counter, StandardCharsets.UTF_8);
            }
            String[]arr=tmp.split(" ");
            for(String item:arr){
                this.commontxt.txt=this.commontxt.txt.replace(item,"*#@");
            }
            writer.write(commontxt.txt.getBytes(StandardCharsets.UTF_8),0,commontxt.txt.getBytes(StandardCharsets.UTF_8).length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
