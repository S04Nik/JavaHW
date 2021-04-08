package com.company.HW09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;

public class ChatClient_First {
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // ридер читающий с консоли
    private static BufferedReader in; // поток чтения из сокета
    private static PrintWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try{

            clientSocket=new Socket("localhost",1000);
            reader=new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out=new PrintWriter(clientSocket.getOutputStream(),true);
            System.out.println("Enter your Nick Name : ");
            String message=""; String response="";
            while(true){
                if(in.ready()){// вопрос остается как не зависать на вводе или ответе отсервера
                    response=in.readLine();
                    System.out.println(">>>>");
                    System.out.println(response);
                }
                if(reader.ready()){// вопрос остается как не зависать на вводе или ответе отсервера
                    message=reader.readLine();
                    out.println(message);
                }

                if(response.equals("bye"))
                    break;
            }

        } catch (SocketException e) {
            System.out.println("bye");
            System.out.println("Server is closed");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
