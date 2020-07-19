package com.example.traveltrip;

import androidx.annotation.NonNull;

public class ForDB {

    private String name;
    private String emaile;
    private String phone;
    private String site;

    public ForDB(String name, String emaile, String phone, String site) {
        this.name = name;
        this.emaile = emaile;
        this.phone = phone;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public String getEmaile() {
        return emaile;
    }

    public String getPhone() {
        return phone;
    }
    public String getSite() {
        return site;
    }


    @Override
    public String toString() {
        return "Название фирмы: " + name+ "\n" + "E-maile: " + emaile +"\n" +"Номер: " + phone + "\n" +"Сайт: " + site;
    }

}
