package com.danielsims.testapp.fitnessplanner.DependencyInjection;

import com.danielsims.testapp.fitnessplanner.Component.AppComponent;
import com.danielsims.testapp.fitnessplanner.Component.DaggerAppComponent;

public class DependencyInjector {

    private static AppComponent mApplicationComponent;

    public static void initialize() {
        mApplicationComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return mApplicationComponent;
    }

    private DependencyInjector(){}
}
