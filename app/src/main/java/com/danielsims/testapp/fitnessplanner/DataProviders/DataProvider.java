package com.danielsims.testapp.fitnessplanner.DataProviders;

import android.content.Context;

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
                    Module.ModuleType.Fitness
        ));

        return modules;
    }

    public List<Module> getFitnessModules(Context context){
        List<Module> fitnessModules = new ArrayList<>();

        fitnessModules.add(new Module(
                "Workout",
                "Create, track and perform your workouts. And some more random text.",
                "Go To Workouts",
                Module.ModuleType.Workout
        ));

        fitnessModules.add(new Module(
                "Weight",
                "Track your weight progress, gain or loss and I can't think of any more shit to put in here ",
                "Go To Weight Tracker",
                Module.ModuleType.WeightTracker
        ));

        return fitnessModules;
    }
}
