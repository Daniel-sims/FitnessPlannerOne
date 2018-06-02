package com.danielsims.testapp.fitnessplanner.RecyclerView.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public interface onActionClickedCallback{
        void goToExerciseActivity();
    }

    private onActionClickedCallback mOnActionClickedCallback;

    public void setOnActionClickedCallback(onActionClickedCallback onActionClickedCallback) {
        mOnActionClickedCallback = onActionClickedCallback;
    }

    @NonNull
    @Override
    public ModulesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_module, parent, false);

        return new ModulesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ModulesAdapter.ViewHolder holder, int position) {
        final Module module = mModuleList.get(position);

        holder.mTitle.setText(module.getTitle());
        holder.mDescription.setText(module.getDescription());
        holder.mActionText.setText(module.getActionName());
        holder.mActionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(module.getModuleType()){
                    case Fitness:
                        mOnActionClickedCallback.goToExerciseActivity();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModuleList.size();
    }
}