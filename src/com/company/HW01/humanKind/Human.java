package com.company.HW01.humanKind;

public class Human {
    public String fullName;
    public int age;
    public String gender;

    Human(){
        fullName="Jhon";
        age=22;
        gender="Male";
    }

    public void sayHi(){
        System.out.println("Hello . I am "+fullName+"\nI am ordinary Human");
    }

}
