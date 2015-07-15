package com.nacho.weatherworld.model;

public interface ModelAggregate<T> {
    int size();
    T get(int index);
}
