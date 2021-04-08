package com.company.HW10;

public class Task2 {
    // конвертируються гривны
    public double convertToDollars(double money)throws ArithmeticException{
        return money/0;
    }
    public double convertToEuro(double money){
        return money*0.030;
    }
    public double convertToFuntSterl(double money){
        return money*0.026;
    }
    public double convertToYen(double money){
        if(money==0)
        {
            throw new ArithmeticException("money == 0");
        }

        return money*3.91;
    }
}
