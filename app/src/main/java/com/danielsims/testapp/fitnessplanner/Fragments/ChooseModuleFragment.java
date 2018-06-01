package com.danielsims.testapp.fitnessplanner.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielsims.testapp.fitnessplanner.Adapters.ModulesAdapter;
import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.FitnessActivity;
import com.danielsims.testapp.fitnessplanner.Fragments.Base.BaseFragment;
import com.danielsims.testapp.fitnessplanner.HomeActivity;
import com.danielsims.testapp.fitnessplanner.Listeners.HomeActivityNavigationListener;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseModuleFragment extends BaseFragment<ChooseModuleViewModel> {

    @BindView(R.id.tool_bar) Toolbar mToolbar;
    @BindView(R.id.modules_recycler_view) RecyclerView mModulesRecyclerView;

    public static ChooseModuleFragment newInstance(){
        return new ChooseModuleFragment();
    }

    private WeakReference<HomeActivityNavigationListener> mNavigationListener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(getActivity() instanceof HomeActivity){
            mNavigationListener = new WeakReference<>(((HomeActivity) getActivity()).getHomeActivityNavigationListener());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_module, parent, false);

        ButterKnife.bind(this, view);
        DependencyInjector.getAppComponent().inject(this);

        mModulesRecyclerView.setHasFixedSize(true);
        mModulesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ModulesAdapter adapter = new ModulesAdapter(mViewModel.getModules(getActivity()));
        ModulesAdapter.onActionClickedCallback callback = new ModulesAdapter.onActionClickedCallback() {
            @Override
            public void goToExerciseActivity() {
                startActivity(new Intent(getActivity(), FitnessActivity.class));
            }
        };

        adapter.setOnActionClickedCallback(callback);
        mModulesRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mToolbar.setTitle(R.string.home_activity_title);
    }
}
