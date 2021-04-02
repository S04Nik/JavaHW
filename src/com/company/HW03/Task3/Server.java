package com.company.HW03.Task3;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Server {
    public ClientComparator comparator = new ClientComparator();
    private TreeSet<Client> line = new TreeSet<Client>(comparator);
    public ClientServer_Statistic statistic = new ClientServer_Statistic();

    public void AddToLine(Client client) {
        try {
            if(!line.add(client))
            {
                System.out.println("EQUALS !!!!!");
            }
            System.out.println(client.Name+" "+client.priority+"Response : 102");
            statistic.AddStatistic(client.Name,new Date().toString());
        } catch (Exception ex) {
            System.out.println("ADD TO SERVER LINE EXCEPTION" + ex.getMessage());
        }
    }
    public void ExecuteRequests(){
        for (Client item:line) {
            System.out.println(item.Request);
        }
    }
}

