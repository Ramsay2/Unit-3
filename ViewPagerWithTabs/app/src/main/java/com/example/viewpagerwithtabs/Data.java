package com.example.viewpagerwithtabs;

public class Data {
    private String name,place,touristPlace;

    public Data(String name, String place, String touristPlace) {
        this.name = name;
        this.place = place;
        this.touristPlace = touristPlace;
    }



    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getTouristPlace() {
        return touristPlace;
    }
}
