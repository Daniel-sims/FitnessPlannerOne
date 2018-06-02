package com.danielsims.testapp.fitnessplanner.Fragments;

import android.content.Context;
import android.content.Intent;
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
import com.danielsims.testapp.fitnessplanner.RecyclerView.Adapters.ModulesAdapter;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;
import com.danielsims.testapp.fitnessplanner.ViewModels.FitnessViewModel;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseWorkoutFragment extends BaseFragment<FitnessViewModel> {

    @BindView(R.id.tool_bar) Toolbar mToolbar;
    @BindView(R.id.modules_recycler_view) RecyclerView mFitnessModulesRecyclerView;

    public static ChooseWorkoutFragment newInstance(){
        return new ChooseWorkoutFragment();
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
        View view = inflater.inflate(R.layout.fragment_choose_workout, parent, false);

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

        mFitnessModulesRecyclerView.setHasFixedSize(true);
        mFitnessModulesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ModulesAdapter adapter = new ModulesAdapter(mViewModel.getFitnessModulesList(getActivity()));
        ModulesAdapter.onActionClickedCallback callback = new ModulesAdapter.onActionClickedCallback() {
            @Override
            public void goToExerciseActivity() {
                startActivity(new Intent(getActivity(), FitnessActivity.class));
            }
        };

        adapter.setOnActionClickedCallback(callback);
        mFitnessModulesRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mToolbar.setTitle(R.string.choose_workout_title);
    }
}
