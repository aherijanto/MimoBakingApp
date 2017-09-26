package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

/**
 * Created by ary on 9/17/17.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String MY_FRAGMENT_VIDEO = "my_fragment_video";
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            //Get EXTRA from intent and attach to Fragment as Argument

            //receive desc and video string from IngredientsAdapter
            Bundle stepbundle = getIntent().getExtras();
            String mydesc = stepbundle.getString("desc");
            String myvideoUrl = stepbundle.getString("videoUrl");

            //send desc and video string to Detailfragment
            Bundle args = new Bundle();
            args.putString("mydesc", mydesc);
            args.putString("myvideourl", myvideoUrl);

            if (savedInstanceState == null) {
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(args);

            }else {
                detailFragment = (DetailFragment) getSupportFragmentManager().getFragment(savedInstanceState, MY_FRAGMENT_VIDEO);
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();


        }


    }


    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, MY_FRAGMENT_VIDEO, detailFragment);
    }
}