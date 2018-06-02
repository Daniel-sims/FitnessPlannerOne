package com.danielsims.testapp.fitnessplanner.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.FitnessActivity;
import com.danielsims.testapp.fitnessplanner.Fragments.Base.BaseFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.FitnessActivityNavigationListener;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.ViewModels.FitnessViewModel;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessHomeFragment extends BaseFragment<FitnessViewModel> {

    @BindView(R.id.tool_bar) Toolbar mToolbar;
    @BindView(R.id.fitness_modules_recycler_view) RecyclerView mModulesRecyclerView;

    public static FitnessHomeFragment newInstance(){
        return new FitnessHomeFragment();
    }

    private WeakReference<FitnessActivityNavigationListener> mFitnessActivityNavigationListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(getActivity() instanceof FitnessActivity){
            mFitnessActivityNavigationListener = new WeakReference<>(((FitnessActivity) getActivity()).getFitnessActivityNavigationListener());
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

        mModulesRecyclerView.setHasFixedSize(true);
        mModulesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mToolbar.setTitle(R.string.fitness_activity_title);
    }
}
