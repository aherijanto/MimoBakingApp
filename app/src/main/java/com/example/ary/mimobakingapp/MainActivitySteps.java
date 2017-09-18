package com.example.ary.mimobakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ary.mimobakingapp.Interface.MyListener;
import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MainActivitySteps extends AppCompatActivity implements MyListener{

    public static final String MY_KEY="com.example.ary.mimobakingapp.my_key";

    private ArrayList<Steps> stepsArrayList;
    private ArrayList<Ingredients> ingredientsArrayList ;
    private Boolean mTabletMode = false;

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

        MainStepsFragment mainStepsFragment = MainStepsFragment.newInstance(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainStepsFragmentContainer, mainStepsFragment).commit();


        //receive recipe from RecipeMainAdapter
        Bundle extras = getIntent().getExtras();
        Recipe recipe= extras.getParcelable("recipe");

        //MainStepsFragment mainFragment = new MainStepsFragment();

        //send ArrayListSteps to MainStepsFragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("steps", recipe);
        mainStepsFragment.setArguments(bundle);

        //FragmentManager fragmentManager=getSupportFragmentManager();
        //fragmentManager.beginTransaction()
        //        .add(R.id.mainStepsFragmentContainer,mainStepsFragment)
         //       .commit();

        if(findViewById(R.id.detailContainer)!= null){
            mTabletMode = true;
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
        }


    }
    private void launchDetailActivity(int position) {
        Steps sendStep= stepsArrayList.get(position);
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("clickedstep", sendStep);
        startActivity(detailIntent);
    }

    private void replaceFragment(int position) {
        Log.i("tab", "replace");
        Bundle args = new Bundle();
        args.putInt("ARGUMENTS", position);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
    }

    public boolean isTablet() {
        return mTabletMode;
    }

    @Override
    public void handleClick(int position) {
        if (isTablet()) {
            replaceFragment(position);
        }else{
            launchDetailActivity(position);
        }


    }

}
