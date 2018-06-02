package com.danielsims.testapp.fitnessplanner.Repositories;

import android.content.Context;

import com.danielsims.testapp.fitnessplanner.DataProviders.DataProvider;
import com.danielsims.testapp.fitnessplanner.Models.Module;

import java.util.List;

public class DataRepository {
    private DataProvider mDataProvider;

    public DataRepository(DataProvider dataProvider){
        mDataProvider = dataProvider;
    }

    public List<Module> getModules(Context context){
        return mDataProvider.getModules(context);
    }

    public List<Module> getFitnessModules(Context context){
        return mDataProvider.getFitnessModules(context);
    }
}
