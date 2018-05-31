package com.danielsims.testapp.fitnessplanner.Fragments.Base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.danielsims.testapp.fitnessplanner.Utils.ViewModelUtil;

import javax.inject.Inject;

public class BaseFragment<T extends ViewModel> extends Fragment {

    @Inject T mViewModel;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        ViewModelProvider.Factory viewModelFactory = ViewModelUtil.createFor(mViewModel);
        ViewModelProviders.of(this, viewModelFactory).get(mViewModel.getClass());
    }
}
