package com.nacho.weatherworld.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nacho.weatherworld.R;
import com.nacho.weatherworld.activities.CityWeatherActivity;
import com.nacho.weatherworld.model.Cities;
import com.nacho.weatherworld.model.City;
import com.nacho.weatherworld.model.MockWeatherAPI;
import com.nacho.weatherworld.util.Constants;

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

        final Cities cities = MockWeatherAPI.getAllCities();

        mAdapter = new CityAdapter(cities, inflater);
        mListCities.setAdapter(mAdapter);

        mListCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CityWeatherActivity.class);

                City city = cities.get(position);

                intent.putExtra(Constants.INTENT_KEY_CITY, city);
                startActivity(intent);
            }
        });

        mListCities.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                // true: LongClick existed
                // false: LongClick = Click

                Toast.makeText(getActivity(), "Long Click", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return view;
    }

    class CityAdapter extends BaseAdapter {

        Cities cities;
        LayoutInflater inflater;

        public CityAdapter(Cities cities, LayoutInflater inflater) {
            this.cities = cities;
            this.inflater = inflater;
        }

        @Override
        public int getCount() {
            return  cities.size();
        }

        @Override
        public Object getItem(int position) {
            return cities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int layoutId;

            if (position % 2 == 0){
                layoutId = R.layout.row_left_icon;
            } else {
                layoutId = R.layout.row_right_icon;
            }

            View row = inflater.inflate(layoutId, parent, false);
            TextView txtCityName = (TextView) row.findViewById(R.id.city_name);

            City city = this.cities.get(position);
            txtCityName.setText(city.getName());

            return row;
        }
    }
}
