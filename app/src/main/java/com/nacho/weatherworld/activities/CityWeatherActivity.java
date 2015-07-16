package com.nacho.weatherworld.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.nacho.weatherworld.R;
import com.nacho.weatherworld.fragments.CityWeatherActivityFragment;
import com.nacho.weatherworld.model.City;
import com.nacho.weatherworld.util.Constants;
import com.nacho.weatherworld.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CityWeatherActivity extends Activity {

    private City city;
    String temp = null;
    String iconName = null;
    Bitmap iconBitmap = null;
    CityWeatherActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);

        Intent intent = getIntent();

        city = (City) intent.getParcelableExtra(Constants.INTENT_KEY_CITY);

        fragment = (CityWeatherActivityFragment) getFragmentManager().findFragmentById(R.id.fragment);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getWeatherDataForCityNamed(city.getName());
                // BACKGROUND WORK

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fragment.refresh(city.getName(), temp, iconBitmap);
                    }
                });
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

        try {
            URL imageUrl = new URL(urlIcon);
            URLConnection connection = imageUrl.openConnection();
            iconBitmap = BitmapFactory.decodeStream(connection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("", "Image downloading problem ".concat(urlIcon));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
