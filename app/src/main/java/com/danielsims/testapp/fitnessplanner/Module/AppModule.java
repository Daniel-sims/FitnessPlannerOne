package com.danielsims.testapp.fitnessplanner.Module;

import android.support.annotation.NonNull;

import com.danielsims.testapp.fitnessplanner.DataProviders.DataProvider;
import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @NonNull
    @Singleton
    public DataRepository provideExerciseRepository(DataProvider dataProvider){
        return new DataRepository(dataProvider);
    }

    @Provides
    @NonNull
    public ChooseModuleViewModel provideMainViewModel(){
        return new ChooseModuleViewModel();
    }

}
