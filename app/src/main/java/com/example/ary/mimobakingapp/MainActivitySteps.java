package com.example.ary.mimobakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ary.mimobakingapp.Interface.MyListener;
import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MainActivitySteps extends AppCompatActivity {

    public static final String MY_KEY="com.example.ary.mimobakingapp.my_key";

    private ArrayList<Steps> stepsArrayList;
    private ArrayList<Ingredients> ingredientsArrayList ;
    private Boolean mTabletMode = false;
    private Recipe recipe;
    private static final String MY_FRAGMENT="my_fragment";
    private MainStepsFragment mainStepsFragment;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, MY_FRAGMENT, mainStepsFragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_steps);

        getActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            mainStepsFragment=new MainStepsFragment();
            Bundle extras = getIntent().getExtras();
            recipe= extras.getParcelable("recipe");


            //MainStepsFragment mainFragment = new MainStepsFragment();

            //send ArrayListSteps to MainStepsFragment
            Bundle bundle = new Bundle();
            bundle.putParcelable("steps", recipe);
            mainStepsFragment.setArguments(bundle);

        } else {
            mainStepsFragment = (MainStepsFragment) getSupportFragmentManager().getFragment(savedInstanceState, MY_FRAGMENT);
        }



        getSupportFragmentManager().beginTransaction().replace(R.id.mainStepsFragmentContainer, mainStepsFragment).commit();


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

    //@Override
    //public void handleClick(int position) {
     //   if (isTablet()) {
     //       replaceFragment(position);
     //   }else{
     //       launchDetailActivity(position);
     //   }


   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homemenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
