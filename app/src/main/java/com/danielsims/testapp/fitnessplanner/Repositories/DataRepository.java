package com.danielsims.testapp.fitnessplanner.Repositories;

import com.danielsims.testapp.fitnessplanner.DataProviders.DataProvider;

public class DataRepository {
    private DataProvider mDataProvider;

    public DataRepository(DataProvider dataProvider){
        mDataProvider = dataProvider;
    }

    /*
    This class is kind of a "middleman" between the ViewModels and the data provider, meaning you can give it
    any kind of data provider wether it's from an API or a local database and it will work seemlessly
     */
}