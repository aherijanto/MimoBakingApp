package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MainActivitySteps extends AppCompatActivity{
    public static final String MY_KEY="com.example.ary.mimobakingapp.my_key";

    private ArrayList<Steps> stepsArrayList;
    private ArrayList<Ingredients> ingredientsArrayList ;

    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        ArrayList parcelSteps = new ArrayList(stepsArrayList);
        ArrayList parcelIngredients = new ArrayList(ingredientsArrayList);
        outState.putParcelableArrayList(MY_KEY,  parcelSteps);
        outState.putParcelableArrayList(MY_KEY,  parcelIngredients);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_steps);

        Bundle extras = getIntent().getExtras();
        Recipe recipe= extras.getParcelable("recipe");

        MainStepsFragment mainFragment = new MainStepsFragment();


        Bundle bundle = new Bundle();
        bundle.putParcelable("steps", recipe);
        mainFragment.setArguments(bundle);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainStepsFragmentContainer,mainFragment)
                .commit();


    }


}
