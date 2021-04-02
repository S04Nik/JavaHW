package com.company.HW03;

import com.company.HW03.Task3.Client;
import com.company.HW03.Task3.Server;

import java.util.Scanner;
import java.util.TreeSet;

public class StartUp{


    public static void main( String []args){
        Scanner in = new Scanner(System.in);
//        Task1 tmp= new Task1();
//        tmp.Menu(in);
//        Task2 tmp2=new Task2();
//        tmp2.Menu(in);
        Server myServer = new Server();
        TreeSet<Client> clients=new TreeSet<Client>();
        clients.add(new Client("Sasha"));
        clients.add(new Client("Ivan"));
        clients.add(new Client("Alex"));
        for (Client item:clients) {
            item.MakeRequest(myServer);
        }
        myServer.statistic.Show();
        myServer.ExecuteRequests();
        in.close();
    }


}