package com.danielsims.testapp.fitnessplanner.RecyclerView.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.RecyclerView.GenericRecyclerAdapter;
import com.danielsims.testapp.fitnessplanner.RecyclerView.Listeners.OnRecyclerObjectClickListener;
import com.danielsims.testapp.fitnessplanner.RecyclerView.ViewHolders.ModuleViewHolder;

public class ModulesAdapter extends GenericRecyclerAdapter<Module, OnRecyclerObjectClickListener<Module>, ModuleViewHolder> {

    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public ModulesAdapter(Context context) {
        super(context);
    }

    /**
     * To be implemented in as specific adapter
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ModuleViewHolder(inflate(R.layout.card_module, parent));
    }
}
