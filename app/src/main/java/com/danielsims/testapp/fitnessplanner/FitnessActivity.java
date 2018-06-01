package com.danielsims.testapp.fitnessplanner;

import android.os.Bundle;

import com.danielsims.testapp.fitnessplanner.Fragments.FitnessHomeFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.FitnessActivityNavigationListener;

import butterknife.ButterKnife;

public class FitnessActivity extends BaseActivity {

    private FitnessActivityNavigationListener mFitnessActivityNavigationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        ButterKnife.bind(this);

        if(savedInstanceState == null){
            onNavigateToFragment(FitnessHomeFragment.newInstance(), false);
        }
    }

    public FitnessActivityNavigationListener getFitnessActivityNavigationListener() {
        if(mFitnessActivityNavigationListener == null){
            mFitnessActivityNavigationListener = new FitnessActivityNavigationListener() {
                //Fragment navigation implementation in here
            };
        }

        return mFitnessActivityNavigationListener;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
