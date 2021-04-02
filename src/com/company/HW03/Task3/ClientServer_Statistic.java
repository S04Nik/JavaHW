package com.company.HW03.Task3;

import java.util.HashMap;
import java.util.Map;

public class ClientServer_Statistic {
    private Map<String, String> Statistic = new HashMap<>();

    public void Show() {
        try {
            System.out.println("");
            System.out.println("------STATISTIC------");
            for (Map.Entry<String, String> item : Statistic.entrySet())
                System.out.println("Client:" + item.getKey() + " - " + item.getValue());
        } catch (Exception ex) {
        }
        System.out.println("-----------------------------");
    }

    protected void AddStatistic(String name, String time) {
        try {
            Statistic.put(name, time);
            System.out.println("-- Statistic Saved --");
        } catch (Exception ex) {
        }

    }

}
