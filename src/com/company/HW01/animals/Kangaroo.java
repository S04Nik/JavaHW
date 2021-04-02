package com.company.HW01.animals;

public class Kangaroo extends Animal {
    Kangaroo(String Name){
        super(Name);
    }
    public void Voice(){
        System.out.println("I am Kangaroo "+Name);
    }
}
