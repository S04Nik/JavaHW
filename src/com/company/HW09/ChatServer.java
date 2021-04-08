package com.company.HW09;

import jdk.jfr.Threshold;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.Exchanger;

public class ChatServer {
    private static List<Socket> clientSocket =new ArrayList<Socket>(); // сокет для общения с клиентом
    private static  ServerSocket server; // сервер-сокет
    private  static BufferedReader in; // поток чтения
    private static PrintWriter out; // поток записи

    public static BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public static PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true); // autoflush - выталкивание
    }

    public static void main(String[] args) {
        try
        {
            // нужен отдельный поток для каждого юзера . потоки будут работать паралельно

            server=new ServerSocket(1000);
            System.out.println("Server is working...");
            int i=0;
            while(clientSocket.size()<2){
                Socket s=server.accept();
                clientSocket.add(s);//добавляем сокеты для общения
                in=getReader(clientSocket.get(i));
                System.out.println("Client : "+clientSocket.get(i).getRemoteSocketAddress());

                String message=in.readLine();

                System.out.println("Name : "+message);
                out=getWriter(clientSocket.get(i));
                out.println("You are connected :)");
                i++;
            }

//            Exchanger<Socket>ex=new Exchanger<Socket>();
            JThread firstClient=new JThread("firstClient", clientSocket.get(0),clientSocket.get(1));
            JThread secondClient=new JThread("secondClient",clientSocket.get(1),clientSocket.get(0));
            firstClient.start();
            secondClient.start();
            try {
                //main ждет пока 2 потока выполнят работу
                firstClient.join();
                secondClient.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            i=0;
//
//            while(clientSocket.size()==2)
//            {
//                String message="";
//                in=getReader(clientSocket.get(i));
//                message=in.readLine();
//                System.out.println(message);
//
//                if(i==0)
//                {
//                    out=getWriter(clientSocket.get(1));
//                    out.println(message);
//                    if(message.equals("bye"))
//                    {
//                        break;
//                    }
//                    i++;
//                }
//                else if (i==1)
//                {
//                    out=getWriter(clientSocket.get(0));
//                    out.println(message);
//                    if(message.equals("bye"))
//                    {
//                        break;
//                    }
//                    i--;
//                }
//
//            }
//
//
        } catch (IOException exception) {
            System.out.println("EXCEPTION");
            exception.printStackTrace();
        }finally {
            for (Socket client:clientSocket){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                in.close();
                out.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
class JThread extends Thread {
    private  static BufferedReader in; // поток чтения
    private static PrintWriter out; // поток записи
    Socket s;
    Socket friend;

//    Exchanger<Socket>ex;
    JThread(String name,Socket s,Socket friend){
        super(name);
        this.s=s;
        this.friend=friend;
//        this.ex=ex;
    }
    public static BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public static PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true); // autoflush - выталкивание
    }
    public void run(){
        try{
            System.out.println("thread started !!!");
            System.out.println(s.getRemoteSocketAddress());

            extracted();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            System.out.println("FINAL");
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }

    }

    private synchronized void extracted() throws IOException {
        while(true)
        {
            in=getReader(s);
            out=getWriter(friend);
            if(in.ready()){ // вдруг reader.ready() выдаст true, а строка будет считана другим потоком и первый зависнет
                // вопрос остается как не зависать на вводе или ответе отсервера
                System.out.println(Thread.currentThread().getName());
                System.out.println("reader ready !"+friend.getRemoteSocketAddress());
                String message="";
                message=in.readLine();
                System.out.println("Message : "+message);
                out.println(message);
                if(message.equals("bye"))
                {
                    break;
                }

            }

        }
    }
}