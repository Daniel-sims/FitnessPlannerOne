package com.danielsims.testapp.fitnessplanner;

import android.app.Application;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;

public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        DependencyInjector.initialize();
    }
}
