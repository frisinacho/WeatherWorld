package com.nacho.weatherworld.model;

public class MockWeatherAPI {
    public static Cities getAllCities() {
        Cities allCities = new Cities();

        for (int i =0; i<1; i++) {
            City city = new City("Málaga", "" + (i + 4));
            allCities.add(city);
            city = new City("Madrid", "" + (i + 4));
            allCities.add(city);
            city = new City("Barcelona", "" + (i + 4));
            allCities.add(city);
            city = new City("Berlín", "" + (i + 4));
            allCities.add(city);
            city = new City("Londres", "" + (i + 4));
            allCities.add(city);
        }

        /*
        for (int i=0; i<18; i++){
            City city = new City("City " + i, "" + (i+4));
            allCities.add(city);
        }
        */

        return allCities;
    }
}
