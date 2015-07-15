package com.nacho.weatherworld.model;

import java.util.ArrayList;
import java.util.List;

public class Cities implements ModelAggregate<City>{

    private List<City> cities = new ArrayList<City>();

    public Cities() {
        cities = new ArrayList<City>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public City get(int index) {
        return null;
    }

    // lazy getter
    public List<City> getCities() {
        if (this.cities == null) {
            this.cities = new ArrayList<City>();
        }
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}