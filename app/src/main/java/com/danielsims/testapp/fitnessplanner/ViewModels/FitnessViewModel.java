package com.danielsims.testapp.fitnessplanner.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class FitnessViewModel extends ViewModel {

    @Inject DataRepository mDataRepository;

    public FitnessViewModel(){
        DependencyInjector.getAppComponent().inject(this);
    }

    public List<Module> getFitnessModulesList(Context context){
        return mDataRepository.getFitnessModules(context);
    }
}
