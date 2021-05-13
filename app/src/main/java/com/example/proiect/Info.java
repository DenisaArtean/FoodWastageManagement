package com.example.proiect;

public class Info {
    private String Username;
    private String Address;
    private String City;
    private int ZipCode;
    private String County;
    private String Date;
    private String PhoneNumber;
    private String FoodLeft;

    public Info(String Username, String Address, String City, int ZipCode, String County, String Date, String PhoneNumber, String FoodLeft) {
        this.Username = Username;
        this.Address = Address;
        this.City = City;
        this.ZipCode = ZipCode;
        this.County = County;
        this.Date = Date;
        this.PhoneNumber = PhoneNumber;
        this.FoodLeft = FoodLeft;
    }

    public String getUsername() {
        return Username;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public String getCounty() {
        return County;
    }

    public String getDate() {
        return Date;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getFoodLeft() {
        return FoodLeft;
    }
}
