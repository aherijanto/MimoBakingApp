package com.example.ary.mimobakingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ary.mimobakingapp.Adapter.IngredientsAdapter;
import com.example.ary.mimobakingapp.Adapter.RecipeMainAdapter;
import com.example.ary.mimobakingapp.Interface.MyListener;
import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MainStepsFragment extends Fragment {

    private RecyclerView mRecyclerview;
    private IngredientsAdapter myadapter;
    private ArrayList<Steps> stepsArrayList;
    private TextView txtIngredient;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main_steps, container, false);


        //receive ArrayListSteps from MainActivitySteps
        Recipe getData = getArguments().getParcelable("steps");

        ArrayList<Steps> getSteps=getData.getSteps();
        ArrayList<Ingredients> getIngredients=getData.getIngredients();

        //write Step List to layout
        myadapter = new IngredientsAdapter(getActivity(),getSteps);

        mRecyclerview = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        txtIngredient=(TextView) rootView.findViewById(R.id.ingredients);
        txtIngredient.setText(getIngredients.toString());

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        mRecyclerview.setLayoutManager(llm);
        mRecyclerview.setAdapter(myadapter);

        return rootView;
    }
}
