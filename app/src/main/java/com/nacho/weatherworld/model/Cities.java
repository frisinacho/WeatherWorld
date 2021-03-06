package com.nacho.weatherworld.model;

import java.util.ArrayList;
import java.util.List;

public class Cities implements ModelAggregate<City>{

    private List<City> cities;

    public Cities() {
    }

    @Override
    public int size() {
        return getCities().size();
    }

    @Override
    public City get(int index) {
        if (index >= 0 && index < getCities().size()) {
            return getCities().get(index);
        }

        return null;
    }

    @Override
    public void add(City city) {
        getCities().add(city);
    }

    // lazy getter - The list it's not created until the first time it's used
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