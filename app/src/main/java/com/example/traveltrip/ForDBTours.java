package com.example.traveltrip;

public class ForDBTours {
    private String nameoftours;
    private String nameoftouroper;
    private String country;
    private String city;
    private String date;
    private String days;
    private String people;
    private String stars;
    private String price;

    public ForDBTours(String nameoftours,String nameoftouroper, String country, String city, String date, String days, String people, String stars, String price) {
        this.nameoftours = nameoftours;
        this.nameoftouroper = nameoftouroper;
        this.country = country;
        this.city = city;
        this.date = date;
        this.days = days;
        this.people = people;
        this.stars = stars;
        this.price = price;
    }

    public String getNameoftours() {
        return nameoftours;
    }
    public String getNameoftouroper() {
        return nameoftouroper;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getDate() {
        return date;
    }
    public String getDays() {
        return days;
    }
    public String getPeople() {
        return people;
    }
    public String getStars() {
        return stars;
    }
    public String getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Название тура: " + nameoftours + "\n" + "Туроператор: " + nameoftouroper + "\n" + "Страна: " + country +"\n" +"Город: " + city + "\n" + "Дата начала: " + date + "\n" + "Дата конца: " + days + "\n" + "Количество людей: " + people + "\n" + "Звезды отеля: " + stars + "\n" + "Цена: " + price;
    }
}
