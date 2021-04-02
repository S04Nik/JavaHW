package com.company.HW03.Task3;

import java.util.*;

public class Client implements Comparable<Client>{
 public int priority;
 public String Name;
 public String Request;
 public Client(String Name){
     Random random=new Random();
     this.Name=Name;
     priority=random.nextInt(3)+1;
     Request=Name+" is Requesting for DATA";

 }
 public void  MakeRequest(Server srv){
    srv.AddToLine(this);
 }

    @Override
    public int compareTo(Client o) {
        return 1;
    }
}

class ClientComparator implements Comparator<Client>{
    @Override
    public int compare(Client o1, Client o2) {
        if(o1.priority<o2.priority)
        {
            return -1;
        }else if(o1.priority>o2.priority)
        {
            return 1;
        }else if(o1.priority==o2.priority)
        {
            return 0;
        }
        return -1;
    }

}

