package com.danielsims.testapp.fitnessplanner;

import android.os.Bundle;

import com.danielsims.testapp.fitnessplanner.Fragments.ChooseModuleFragment;
import com.danielsims.testapp.fitnessplanner.Listeners.HomeActivityNavigationListener;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    private HomeActivityNavigationListener mHomeActivityNavigationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        if(savedInstanceState == null){
            onNavigateToFragment(ChooseModuleFragment.newInstance(), false);
        }
    }

    public HomeActivityNavigationListener getHomeActivityNavigationListener() {
        if(mHomeActivityNavigationListener == null){
            mHomeActivityNavigationListener = new HomeActivityNavigationListener() {
                //Fragment navigation implementation in here
            };
        }

        return mHomeActivityNavigationListener;
    }

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }
}
