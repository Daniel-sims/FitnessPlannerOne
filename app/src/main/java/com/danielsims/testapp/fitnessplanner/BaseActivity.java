package com.danielsims.testapp.fitnessplanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public void onNavigateToFragment(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment);

        if(addToBackstack){
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}
