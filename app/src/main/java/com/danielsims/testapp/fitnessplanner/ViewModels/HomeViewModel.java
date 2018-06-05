package com.danielsims.testapp.fitnessplanner.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.Entities.Module;
import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    private final DataRepository mDataRepository;

    @Inject
    public HomeViewModel(DataRepository dataRepository){
        DependencyInjector.getAppComponent().inject(this);

        mDataRepository = dataRepository;
    }

    public List<Module> getModules(Context context){
        return mDataRepository.getModules(context);
    }
}
