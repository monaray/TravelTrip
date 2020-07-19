package com.example.traveltrip;

public class ForDBSpinner {
    private String name;

    public ForDBSpinner(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}
