package com.danielsims.testapp.fitnessplanner.Utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

@SuppressWarnings("unchecked")
public class ViewModelUtil {

    private ViewModelUtil() {}

    public static <T extends ViewModel> ViewModelProvider.Factory createFor(final T model) {
        return new ViewModelProvider.Factory() {
            @Override
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                if (modelClass.isAssignableFrom(model.getClass())) {
                    return (T) model;
                }

                throw new IllegalArgumentException("unexpected model class " + modelClass);
            }
        };
    }
}
