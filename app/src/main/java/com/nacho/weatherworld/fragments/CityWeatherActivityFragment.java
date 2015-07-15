package com.nacho.weatherworld.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nacho.weatherworld.R;

public class CityWeatherActivityFragment extends Fragment {

    TextView cityName;
    TextView temperature;
    ImageView weatherIcon;

    public CityWeatherActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_city_weather, container, false);

        cityName = (TextView) view.findViewById(R.id.city_name);
        temperature = (TextView) view.findViewById(R.id.temperature);
        weatherIcon = (ImageView) view.findViewById(R.id.weather_icon);

        return view;
    }

    public void refresh(String temp, String iconName) {
        temperature.setText(temp);
    }
}
