package com.danielsims.testapp.fitnessplanner.Component;

import com.danielsims.testapp.fitnessplanner.Fragments.ChooseModuleFragment;
import com.danielsims.testapp.fitnessplanner.Module.AppModule;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = { AppModule.class})
@Singleton
public interface AppComponent {
    void inject(ChooseModuleViewModel chooseModuleViewModel);
    void inject(ChooseModuleFragment chooseModuleFragment);
}
