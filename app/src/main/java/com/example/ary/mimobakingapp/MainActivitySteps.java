package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ary on 9/17/17.
 */

public class MainActivitySteps extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_steps);

        MainStepsFragment mainFragment = new MainStepsFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.mainStepsFragmentContainer,mainFragment)
                .commit();


    }


}
