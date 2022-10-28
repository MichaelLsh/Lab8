package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }


    /**
     * This function returns true if the given city is existing, otherwise false
     * @param city
     * This is the given city with a type of {@link City} to check if it belongs to the city list with a type of {@link List}
     * @return Return type is {@link boolean}
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;
        }
        return false;
    }

    /*
     * This function delete the given city if it exists inside the list of cities
     * @param city
     * This is the given city with a type of {@link City} to check if it exists inside the city list, if so then remove it from the city list with a type of {@link List}
     * @return
     * */
    public void deleteCity(City city){
        if (cities.contains(city)){
            cities.remove(city);
        } else{
            throw new IllegalArgumentException();
        }
    }

}
