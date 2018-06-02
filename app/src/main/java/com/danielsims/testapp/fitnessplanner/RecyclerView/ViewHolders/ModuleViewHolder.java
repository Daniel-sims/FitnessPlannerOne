package com.danielsims.testapp.fitnessplanner.RecyclerView.ViewHolders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.danielsims.testapp.fitnessplanner.Models.Module;
import com.danielsims.testapp.fitnessplanner.R;
import com.danielsims.testapp.fitnessplanner.RecyclerView.Listeners.OnRecyclerObjectClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModuleViewHolder extends BaseViewHolder<Module, OnRecyclerObjectClickListener<Module>> {
    @BindView(R.id.title_text_id) TextView title;
    @BindView(R.id.description_text_id) TextView description;
    @BindView(R.id.action_text_id) TextView actionText;

    public ModuleViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    /**
     * Bind data to the item and set listener if needed.
     *
     * @param item     object, associated with the item.
     * @param listener listener a listener {@link BaseRecyclerListener} which has to b set at the item (if not `null`).
     */
    @Override
    public void onBind(final Module module, @Nullable final OnRecyclerObjectClickListener<Module> listener) {
        title.setText(module.getTitle());
        description.setText(module.getDescription());
        actionText.setText(module.getActionName());

        if (listener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(module);
                }
            });
        }
    }
}