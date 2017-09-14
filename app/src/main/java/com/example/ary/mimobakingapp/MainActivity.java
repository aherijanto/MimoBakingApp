package com.example.ary.mimobakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ary.mimobakingapp.API.RecipeInterface;
import com.example.ary.mimobakingapp.Adapter.RecipeMainAdapter;
import com.example.ary.mimobakingapp.Model.RecipeJSONResponse;
import com.example.ary.mimobakingapp.Model.RecipeMain;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRecipeMain;
    private ArrayList<RecipeMain> myRecipeMain;
    private RecipeMainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        rvRecipeMain = (RecyclerView)findViewById(R.id.rv_page_1);
        rvRecipeMain.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvRecipeMain.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RecipeInterface request = retrofit.create(RecipeInterface.class);
        Call<RecipeJSONResponse> call = request.getJSON();
        call.enqueue(new Callback<RecipeJSONResponse>() {
            @Override
            public void onResponse(Call<RecipeJSONResponse> call, Response<RecipeJSONResponse> response) {

                RecipeJSONResponse jsonResponse = response.body();
                myRecipeMain = new ArrayList<RecipeMain>(Arrays.asList(jsonResponse.getMyRecipe()));
                adapter = new RecipeMainAdapter(myRecipeMain);
                rvRecipeMain.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RecipeJSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
