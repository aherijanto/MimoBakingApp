package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ary.mimobakingapp.Model.Recipe;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MainActivitySteps extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_steps);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> recipe= extras.getStringArrayList("recipe");

        MainStepsFragment mainFragment = new MainStepsFragment();


        Bundle bundle = new Bundle();
        bundle.putString("steps", String.valueOf(recipe));
        mainFragment.setArguments(bundle);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainStepsFragmentContainer,mainFragment)
                .commit();


    }


}
