package com.nacho.weatherworld;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.nacho.weatherworld.model.Cities;
import com.nacho.weatherworld.model.MockWeatherAPI;

public class MainActivityFragment extends Fragment {

    private ListView mListCities;
    private CityAdapter mAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mListCities = (ListView) view.findViewById(R.id.cityList);

        Cities cities = MockWeatherAPI.getAllCities();

        mAdapter = new CityAdapter();
        mListCities.setAdapter(mAdapter);

        return view;
    }

    class CityAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
