package com.danielsims.testapp.fitnessplanner.Repositories;

import android.content.Context;

import com.danielsims.testapp.fitnessplanner.Entities.Module;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataRepository {

    @Inject
    public DataRepository(){

    }

    public List<Module> getModules(Context context){
        List<Module> modules = new ArrayList<>();

        modules.add(
                new Module
                        ("1",
                                "Workout",
                                "Workout",
                                "Blah blah blah blah blah blah blah blah blah blahhhhh blah blah",
                                "Workout",
                                "Go Workout"
                        ));

        return modules;
    }
}
