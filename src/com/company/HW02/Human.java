    package com.company.HW02;

    import java.text.DateFormat;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    public class Human {
    private String fullName;
    public Date birthDay;
    private String phone;
    public String city;
    public String country;
    private String streetAddress;

    Human(String fullName,Date birthDay, String phone,
      String city,String country, String streetAddress){
    this.fullName=fullName;
    this.birthDay=birthDay;
    this.phone=phone;
    this.city=city;
    this.country=country;
    this.streetAddress=streetAddress;
}
    Human(Human obj ){
        this.fullName=obj.fullName;
        this.birthDay=obj.birthDay;
        this.phone=obj.phone;
        this.city=obj.city;
        this.country=obj.country;
        this.streetAddress=obj.streetAddress;
    }
    Human(){
        SetInfo();
    }

    public String GetName(){
        return this.fullName;
    }
    public String GetPhone(){
        return this.phone;
    }
    public String GetStreetAddress(){
            return this.streetAddress;
        }
    public void SetName(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter name :");
        this.fullName=scan.next();
    }
    public void SetPhone(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter phone :");
        this.phone=scan.next();
    }
    public void SetStreetAddress(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter street Address :");
        this.streetAddress=scan.next();
    }
    public String GetHomeAddress(){
        return this.streetAddress;
    }
    public void SetInfo() {
        System.out.println("-- HUMAN --");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter First and last names :");
        this.fullName=scanner.next();
        System.out.println("Enter birthday date in format dd/MM/yyyy:");
        String dateString = scanner.next();
        //System.out.println(dateString);

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.birthDay = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter phone number:");
        this.phone=scanner.next();
        System.out.println("Enter country:");
        this.country=scanner.next();
        System.out.println("Enter city:");
        this.city=scanner.next();
        System.out.println("Enter street address:");
        this.streetAddress=scanner.next();
        System.out.println("--DONE--");
        scanner.close();
    }
    public void GetInfo(){
        System.out.println("Name: "+this.fullName);
        System.out.println("Birthday: "+this.birthDay);
        System.out.println("Phone Number: "+this.phone);
        System.out.println("City: "+this.city);
        System.out.println("Country: "+this.country);
        System.out.println("Street: "+this.streetAddress);
    }

}

