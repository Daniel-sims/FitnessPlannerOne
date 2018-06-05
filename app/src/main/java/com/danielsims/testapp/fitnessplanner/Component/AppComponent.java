package com.danielsims.testapp.fitnessplanner.Component;

import com.danielsims.testapp.fitnessplanner.Fragments.HomeFragment;
import com.danielsims.testapp.fitnessplanner.Fragments.WorkoutFragment;
import com.danielsims.testapp.fitnessplanner.Module.AppModule;
import com.danielsims.testapp.fitnessplanner.ViewModels.HomeViewModel;
import com.danielsims.testapp.fitnessplanner.ViewModels.WorkoutViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { AppModule.class })
@Singleton
public interface AppComponent {
    void inject(HomeViewModel homeViewModel);
    void inject(HomeFragment homeFragment);

    void inject(WorkoutFragment fitnessHomeFragment);

    void inject(WorkoutViewModel workoutViewModel);
}
