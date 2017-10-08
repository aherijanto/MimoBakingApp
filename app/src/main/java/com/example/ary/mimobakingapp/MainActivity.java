package com.example.ary.mimobakingapp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
    private ArrayList<Recipe> recipeList;
    private AppCompatActivity activity=MainActivity.this;
    public static final String MY_KEY="com.example.ary.mimobakingapp.my_key";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        ArrayList parcelRecipe = new ArrayList(recipeList);
        outState.putParcelableArrayList(MY_KEY,  parcelRecipe);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        rvRecipeMain = (RecyclerView)findViewById(R.id.rv_page_1);
        recipeList = new ArrayList<Recipe>();
        rvAdapter = new RecipeMainAdapter(this,recipeList);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvRecipeMain.setLayoutManager(new GridLayoutManager(this, 1));
        } else {
            rvRecipeMain.setLayoutManager(new GridLayoutManager(this, 2));
        }
        //rvRecipeMain.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvRecipeMain.setLayoutManager(layoutManager);
        rvRecipeMain.setAdapter(rvAdapter);

        rvAdapter.notifyDataSetChanged();

        if (savedInstanceState == null) {
            new FetchRecipe().execute();
        } else {
            ArrayList parcelRecipe = savedInstanceState.getParcelableArrayList(MY_KEY);
            rvRecipeMain.setAdapter(new RecipeMainAdapter(getApplicationContext(), parcelRecipe));

        }
    }

    public class FetchRecipe extends AsyncTask<String,Void,ArrayList<Recipe>>{

        @Override
        protected ArrayList<Recipe> doInBackground(String... params) {

            URL RecipeRequestUrl = ConnectUtils.buildURL();

            try {
                String RecipeResponse = ConnectUtils.getResponseFromHttpUrl(RecipeRequestUrl);

                 ArrayList<Recipe> JsonRecipeData = RecipeOnJSON.getRecipeName(MainActivity.this,RecipeResponse);


                return JsonRecipeData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Recipe> strings) {
            if (strings != null) {

                rvRecipeMain.setAdapter(new RecipeMainAdapter(getApplicationContext(), strings));;
                recipeList=strings;

                }
            }
        }

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();

        }

        return this;

    }
    }





