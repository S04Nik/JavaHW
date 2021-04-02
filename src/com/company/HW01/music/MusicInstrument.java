package com.company.HW01.music;

public class MusicInstrument{
    public String Name;
    public String Description;
    public String Sound;
    public String History;

    MusicInstrument(){};
    MusicInstrument(String Name,String Description,String Sound,String History){
        this.Description=Description;
        this.History=History;
        this.Name=Name;
        this.Sound=Sound;
    };
    public void Show(){
        System.out.println("Name: "+Name);
    }
    public void Desc(){
        System.out.println("Description: "+Description);
    }
    public void Sound(){
        System.out.println("Sound: "+Sound);
    }
    public void History(){
        System.out.println("History: "+History);
    }
}
