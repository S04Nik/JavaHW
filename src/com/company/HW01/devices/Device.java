package com.company.HW01.devices;

public class Device {
    public String Name;
    public String Description;
    public String Sound;
    Device(){}
    Device(String Name,String Description,String Sound){
        this.Name=Name;
        this.Description=Description;
        this.Sound=Sound;
    }
    public void Show(){
        System.out.println("Name: "+Name);
    }
    public void Desc(){
        System.out.println("Description: "+Description);
    }
    public void Sound(){
        System.out.println("Sound: "+Sound);
    }
}
