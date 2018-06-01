package com.danielsims.testapp.fitnessplanner.ViewModels;

import android.arch.lifecycle.ViewModel;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class ChooseModuleViewModel extends ViewModel {

    @Inject DataRepository mDataRepository;

    public ChooseModuleViewModel(){
        DependencyInjector.getAppComponent().inject(this);
    }

    public List<Module> getModules(){
        return mDataRepository.getModules();
    }
}
