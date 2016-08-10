package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aishwarya on 8/8/16.
 */
public class CountryList {
    @SerializedName("Countries")
    private ArrayList<Country> mCountries;


    public ArrayList<Country> getCountries() {
        return mCountries;
    }

    public void setCountries(ArrayList<Country> countries) {
        mCountries = countries;
    }
}
