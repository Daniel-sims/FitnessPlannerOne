package com.danielsims.testapp.fitnessplanner.Module;

import android.support.annotation.NonNull;

import com.danielsims.testapp.fitnessplanner.Repositories.DataRepository;
import com.danielsims.testapp.fitnessplanner.ViewModels.HomeViewModel;
import com.danielsims.testapp.fitnessplanner.ViewModels.WorkoutViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @NonNull
    @Singleton
    public DataRepository provideExerciseRepository(){
        return new DataRepository();
    }

    @Provides
    @NonNull
    public HomeViewModel provideMainViewModel(DataRepository dataRepository){
        return new HomeViewModel(dataRepository);
    }

    @Provides
    @NonNull
    public WorkoutViewModel provideWorkoutViewModel(){
        return new WorkoutViewModel();
    }
}
