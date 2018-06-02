package com.danielsims.testapp.fitnessplanner.ViewModels;

import android.arch.lifecycle.ViewModel;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;

import javax.inject.Inject;

public class WorkoutViewModel extends ViewModel {

    @Inject DataRepository mDataRepository;

    public WorkoutViewModel(){
        DependencyInjector.getAppComponent().inject(this);
    }
}
