package com.danielsims.testapp.fitnessplanner;

import android.os.Bundle;

import com.danielsims.testapp.fitnessplanner.Fragments.WorkoutFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.WorkoutActivityNavigationListener;

import butterknife.ButterKnife;

public class WorkoutActivity extends BaseActivity {

    private WorkoutActivityNavigationListener mWorkoutActivityNavigationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        ButterKnife.bind(this);

        if(savedInstanceState == null){
            onNavigateToFragment(WorkoutFragment.newInstance(), false);
        }
    }

    public WorkoutActivityNavigationListener getFitnessActivityNavigationListener() {
        if(mWorkoutActivityNavigationListener == null){
            mWorkoutActivityNavigationListener = new WorkoutActivityNavigationListener() {

            };
        }

        return mWorkoutActivityNavigationListener;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
