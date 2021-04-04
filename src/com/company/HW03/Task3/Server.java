package com.company.HW03.Task3;

import java.util.*;

public class Server {
    public Comparator<Client> comparator =new ClientComparatorPriority()
            .thenComparing(new ClientComparatorTime());
    private TreeSet<Client> line = new TreeSet<Client>(comparator);
    public ClientServer_Statistic statistic = new ClientServer_Statistic();

    public void AddToLine(Client client) {
        try {

            if(!line.add(client))
            {
                System.out.println("EQUALS !!!!!");
            }
            System.out.println(client.Name+" _ "+client.priority+" _Response : 102");
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

