package com.nacho.weatherworld.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nacho.weatherworld.R;
import com.nacho.weatherworld.model.City;
import com.nacho.weatherworld.util.Constants;
import com.nacho.weatherworld.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityWeatherActivity extends Activity {

    private City city;
    String temp = null;
    String iconName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);

        Intent intent = getIntent();

        city = (City) intent.getParcelableExtra(Constants.INTENT_KEY_CITY);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getWeatherDataForCityNamed(city.getName());
            }
        }).start();

    }

    private void getWeatherDataForCityNamed(String name) {

        String urlRequest = String.format(Constants.BASE_URL, name);

        JSONObject json = JSONUtil.getJSONFromHttpRequest(urlRequest);
        try {
            JSONObject main = json.getJSONObject("main");
            temp = main.getString("temp");

            JSONArray weather = json.getJSONArray("weather");
            JSONObject weather1 = weather.getJSONObject(0);
            iconName = weather1.getString("icon");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String urlIcon = String.format(Constants.WEATHER_ICON_URL, iconName);

    }
}
