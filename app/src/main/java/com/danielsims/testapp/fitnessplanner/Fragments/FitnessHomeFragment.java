package com.danielsims.testapp.fitnessplanner.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.FitnessActivity;
import com.danielsims.testapp.fitnessplanner.Fragments.Base.BaseFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.FitnessActivityNavigationListener;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessHomeFragment extends BaseFragment<ChooseModuleViewModel> {

    @BindView(R.id.tool_bar) Toolbar mToolbar;

    public static FitnessHomeFragment newInstance(){
        return new FitnessHomeFragment();
    }

    private WeakReference<FitnessActivityNavigationListener> mNavigationListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(getActivity() instanceof FitnessActivity){
            mNavigationListener = new WeakReference<>(((FitnessActivity) getActivity()).getFitnessActivityNavigationListener());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fitness_home, parent, false);

        ButterKnife.bind(this, view);
        DependencyInjector.getAppComponent().inject(this);

        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        if(appCompatActivity != null){
            appCompatActivity.setSupportActionBar(mToolbar);
            ActionBar actionBar = appCompatActivity.getSupportActionBar();

            if(actionBar != null){
                appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mToolbar.setTitle(R.string.fitness_activity_title);
    }
}
