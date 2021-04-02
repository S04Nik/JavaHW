package com.company.HW02;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Fraction {
        private int numerator;
        private int denominator;
    Fraction(){
        System.out.println("-- Fraction --");
        SetInfo();
    }
    Fraction(Fraction obj){
        this.numerator=obj.numerator;
        this.denominator=obj.denominator;
    }
    public void GetInfo(){
        System.out.println(numerator+"/"+denominator);
    }
    public int[] SetFraction(){
        int arr[] = new int[2];

        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter numerator :");
            arr[0]=scan.nextInt();
            System.out.println("Enter denominator :");
            arr[1]=scan.nextInt();
            scan.close();
            return arr;
        }
        catch (InputMismatchException e)
        {
           e.printStackTrace();
            return arr;
        }

    }
    public int GetNumerator(){
        return this.numerator;
    }
    public int GetDenominator(){
        return this.denominator;
    }
    public void PrepareResult(int a,int b){
        int integ=0;
        if(a>b) {
            while (a > b) {
                a = a - b;
                integ++;
            }
            if (a == b) {
                integ++;
                System.out.println("Result : " + integ);
            } else {
                System.out.println("         " + " " + a);
                if(a>9||b>9)
                    System.out.println("Result : " + integ + "--");
                else
                    System.out.println("Result : " + integ + "-");
                System.out.println("         " + " " + b);
            }
        }
        else{
            System.out.println(a);
            if(a>9||b>9)
            System.out.println("--");
            else
                System.out.println("-");
            System.out.println(b);
        }
    }
    public int[] changeBothDenominators(int[]arrSecond){
        int[] BothFractions=new int[]{this.numerator,this.denominator, arrSecond[0],arrSecond[1]};
        try {
            BothFractions[0] *= arrSecond[1];
            BothFractions[1] *= arrSecond[1];
            BothFractions[2] *= this.denominator;
            BothFractions[3] *= this.denominator;

            return BothFractions;
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
            return BothFractions;
        }
    }
    public int[] changeBothDenominators(Fraction obj){
        int[] BothFractions=new int[]{this.numerator,this.denominator, obj.numerator,obj.denominator};
        try{
        BothFractions[0]*=obj.denominator;
        BothFractions[1]*=obj.denominator;
        BothFractions[2]*=this.denominator;
        BothFractions[3]*=this.denominator;

        return BothFractions;}
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
            return BothFractions;
        }
    }
    public void Addition(){
        int[]arrSecond=SetFraction();
        if(arrSecond[1]==this.denominator)
        {
            PrepareResult(this.numerator+arrSecond[0],this.denominator);
        }else
        {
            int[]tmp=changeBothDenominators(arrSecond);
            PrepareResult(tmp[0]+tmp[2],tmp[1]);
        }

    }
    public void Subtraction(){
        int[]arrSecond=SetFraction();
        if(arrSecond[1]==this.denominator)
        {
            PrepareResult(this.numerator-arrSecond[0],this.denominator);
        }else
        {
            int[]tmp=changeBothDenominators(arrSecond);
            PrepareResult(tmp[0]-tmp[2],tmp[1]);
        }

    }
    public void Multiplication(){
        int[]arrSecond=SetFraction();
        PrepareResult(this.numerator*arrSecond[0],this.denominator*arrSecond[1]);
    }
    public void Division(){
        try {
            int[] arrSecond = SetFraction();
            PrepareResult(this.numerator * arrSecond[1] ,this.denominator * arrSecond[0]);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    public void Addition(Fraction obj){

        if(obj.denominator==this.denominator)
        {
            PrepareResult(this.numerator+obj.numerator,this.denominator+obj.denominator);
        }else
        {
            int[]tmp=changeBothDenominators(obj);
            PrepareResult(tmp[0]+tmp[2],tmp[1]);
        }

    }
    public void Subtraction(Fraction obj){

        if(obj.denominator==this.denominator)
        {
            PrepareResult(this.numerator-obj.numerator,this.denominator);
        }else
        {
            int[]tmp=changeBothDenominators(obj);
            PrepareResult(tmp[0]-tmp[2],tmp[1]);
        }

    }
    public void Multiplication(Fraction obj){
        PrepareResult(this.numerator*obj.numerator,this.denominator*obj.denominator);
    }
    public void Division(Fraction obj){
        try{
            PrepareResult(this.numerator*obj.denominator,this.denominator*obj.numerator);
        }
        catch(ArithmeticException e){
        System.out.println(e.getMessage());
        }
    }
    public void SetInfo() {
        try{

            Scanner scan=new Scanner(System.in);
            System.out.println("Enter numerator :");
            this.numerator=scan.nextInt();
            System.out.println("Enter denominator :");
            this.denominator=scan.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}


