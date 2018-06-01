package com.danielsims.testapp.fitnessplanner.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielsims.testapp.fitnessplanner.DependencyInjection.DependencyInjector;
import com.danielsims.testapp.fitnessplanner.Fragments.Base.BaseFragment;
import com.danielsims.testapp.fitnessplanner.HomeActivity;
import com.danielsims.testapp.fitnessplanner.Listeners.HomeActivityNavigationListener;
import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.ViewModels.ChooseModuleViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

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
        mModulesRecyclerView.setAdapter(new ModulesAdapter(mViewModel.getModules(getActivity())));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mToolbar.setTitle(R.string.home_activity_title);
    }

    public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.ViewHolder> {
        private List<Module> mModuleList;

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.title_text_id) TextView mTitle;
            @BindView(R.id.description_text_id) TextView mDescription;
            @BindView(R.id.action_text_id) TextView mActionText;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        public ModulesAdapter(List<Module> modulesList) {
            mModuleList = modulesList;
        }

        @NonNull
        @Override
        public ModulesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_module, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Module module = mModuleList.get(position);

            holder.mTitle.setText(module.getTitle());
            holder.mDescription.setText(module.getDescription());
            holder.mActionText.setText(module.getActionName());
            holder.mActionText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(module.getActionIntent());
                }
            });
        }

        @Override
        public int getItemCount() {
            return mModuleList.size();
        }
    }
}
