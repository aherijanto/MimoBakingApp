package com.example.ary.mimobakingapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.ary.mimobakingapp.Adapter.RecipeMainAdapter;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Utilities.ConnectUtils;
import com.example.ary.mimobakingapp.Utilities.RecipeOnJSON;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;




public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRecipeMain;
    private RecipeMainAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rvRecipeMain = (RecyclerView)findViewById(R.id.rv_page_1);
        rvRecipeMain.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvRecipeMain.setLayoutManager(layoutManager);



        new FetchRecipe().execute();

    }

    public class FetchRecipe extends AsyncTask<String,Void,ArrayList<Recipe>>{

        @Override
        protected String[] doInBackground(String... params) {



            URL RecipeRequestUrl = ConnectUtils.buildURL();

            try {
                String RecipeResponse = ConnectUtils.getResponseFromHttpUrl(RecipeRequestUrl);

                 String [] JsonRecipeData = RecipeOnJSON.getRecipeName(MainActivity.this,RecipeResponse);


                return JsonRecipeData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] strings) {
            if (strings != null) {

                rvRecipeMain.setAdapter(rvAdapter);


                }
            }
        }
    }





