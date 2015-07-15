package com.nacho.weatherworld.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nacho.weatherworld.R;
import com.nacho.weatherworld.model.City;
import com.nacho.weatherworld.util.Constants;

public class CityWeatherActivity extends Activity {

    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);

        Intent intent = getIntent();

        city = (City) intent.getParcelableExtra(Constants.INTENT_KEY_CITY);

        getWeatherDataForCityNamed(city.getName());

    }

    private void getWeatherDataForCityNamed(String name) {

    }
}
