package com.company.HW03.Task3;

import java.util.*;

public class Client implements Comparable<Client>{
 protected int priority;
 public String Name;
 public String Request;
 protected Date RequestTime=null;
 public Client(String Name){
     Random random=new Random();
     this.Name=Name;
     priority=random.nextInt(3)+1;
     Request=Name+" is Requesting for DATA";
 }
 public int getPriority(){
     return this.priority;
 }
 public void  MakeRequest(Server srv){
    this.RequestTime=new Date();
    srv.AddToLine(this);
 }

    @Override
    public int compareTo(Client o) {
        if(this.Name!=o.Name)
        {
            return 1;
        }else
            return 0;

    }
}

class ClientComparatorPriority implements Comparator<Client>{
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
        }else
        return -1;
    }

}
//class ClientComparatorName implements Comparator<Client>{
//    @Override
//    public int compare(Client o1, Client o2) {
//        if(o1.Name!=o2.Name)
//        {
//            return -1;
//        }else
//        return 0;
//    }
//
//}
class ClientComparatorTime implements Comparator<Client>{
    @Override
    public int compare(Client o1, Client o2) {
        return o1.RequestTime.compareTo(o2.RequestTime);
    }

}
