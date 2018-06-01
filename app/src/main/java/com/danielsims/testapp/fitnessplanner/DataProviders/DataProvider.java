package com.danielsims.testapp.fitnessplanner.DataProviders;

import android.content.Context;
import android.content.Intent;

import com.danielsims.testapp.fitnessplanner.FitnessActivity;
import com.danielsims.testapp.fitnessplanner.Models.Module;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataProvider {

    @Inject
    public DataProvider(){
    }

    /*
    This class can contain any kind of data provider such as a Room database, an API etc...
     */

    public List<Module> getModules(Context context){
        List<Module> modules = new ArrayList<>();

        modules.add(new Module
                (
             "Exercise",
        "Track your exercise, fitness and weight. Some more random text to make it look like there's more than there is.",
        "Go To Exercise",
                    new Intent(context, FitnessActivity.class)
        ));

        return modules;
    }
}
