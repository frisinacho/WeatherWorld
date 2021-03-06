package com.nacho.weatherworld.model;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private String name;
    private String temp;

    public City(/*@NonNull*/ final String name, final String temp){

        this.name = name;
        this.temp = temp;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.temp);
    }

    protected City(Parcel in) {
        this.name = in.readString();
        this.temp = in.readString();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
