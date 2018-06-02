package com.danielsims.testapp.fitnessplanner.Component;

import com.danielsims.testapp.fitnessplanner.Fragments.ChooseModuleFragment;
import com.danielsims.testapp.fitnessplanner.Fragments.ChooseWorkoutFragment;
import com.danielsims.testapp.fitnessplanner.Fragments.FitnessHomeFragment;
import com.danielsims.testapp.fitnessplanner.Module.AppModule;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;
import com.danielsims.testapp.fitnessplanner.ViewModels.FitnessViewModel;
import com.danielsims.testapp.fitnessplanner.ViewModels.WorkoutViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { AppModule.class})
@Singleton
public interface AppComponent {
    void inject(ChooseModuleViewModel chooseModuleViewModel);
    void inject(ChooseModuleFragment chooseModuleFragment);

    void inject(FitnessViewModel fitnessViewModel);
    void inject(FitnessHomeFragment fitnessHomeFragment);

    void inject(WorkoutViewModel workoutViewModel);
    void inject(ChooseWorkoutFragment chooseWorkoutFragment);
}
