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
import com.danielsims.testapp.fitnessplanner.Fragments.Base.BaseFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.WorkoutActivityNavigationListener;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.ViewModels.WorkoutViewModel;
import com.danielsims.testapp.fitnessplanner.WorkoutActivity;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkoutFragment extends BaseFragment<WorkoutViewModel> {

    @BindView(R.id.tool_bar) Toolbar mToolbar;

    public static WorkoutFragment newInstance(){
        return new WorkoutFragment();
    }

    private WeakReference<WorkoutActivityNavigationListener> mFitnessActivityNavigationListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(getActivity() instanceof WorkoutActivity){
            mFitnessActivityNavigationListener = new WeakReference<>(((WorkoutActivity) getActivity()).getFitnessActivityNavigationListener());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout, parent, false);

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

        mToolbar.setTitle(R.string.workout_activity_title);
    }
}
