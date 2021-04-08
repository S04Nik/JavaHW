package com.company.HW10;

public class Task3 {
    public boolean polindromCheck(String str){
        return str.replaceAll("\\W","") // убираем знаки припинания
                .equalsIgnoreCase(new StringBuilder(str.replaceAll("\\W",""))
                        .reverse().toString());
    }
    public int countVowel(String str){
        return str.replaceAll("[^aeiouAEIOU]","").length();
    }
    public int countConsonant(String str){
        return  str.replaceAll("(?i)[\\saeiou]", "").length();
    }
    public int wordCount(String str,String word){
        return str.split(word).length;
    }

}
