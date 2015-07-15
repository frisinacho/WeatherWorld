package com.nacho.weatherworld.model;

public class MockWeatherAPI {
    public static Cities getAllCities() {
        Cities allCities = new Cities();

        for (int i =0; i<10; i++) {
            City city = new City("City " + i, "" + (i+4));
        }

        return allCities;
    }
}
