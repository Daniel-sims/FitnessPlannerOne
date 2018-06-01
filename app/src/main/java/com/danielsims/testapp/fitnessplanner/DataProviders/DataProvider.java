package com.danielsims.testapp.fitnessplanner.DataProviders;

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

    public List<Module> getModules(){
        List<Module> modules = new ArrayList<>();

        modules.add(new Module(
                    "Exercise",
                    "Track your exercise and fitness",
                    "Go To Exercise")
        );

        return modules;
    }
}
