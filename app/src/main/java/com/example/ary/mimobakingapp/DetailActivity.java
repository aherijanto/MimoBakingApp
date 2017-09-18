package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ary.mimobakingapp.Model.Recipe;

/**
 * Created by ary on 9/17/17.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null) {
            //Get EXTRA from intent and attach to Fragment as Argument

            Bundle stepbundle = getIntent().getExtras();
            String mystep= stepbundle.getParcelable("clickedstep");

            Bundle args = new Bundle();
            args.putString("mystep", mystep);

            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, detailFragment).commit();
        }
    }
}
