package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ary.mimobakingapp.Adapter.IngredientsAdapter;
import com.example.ary.mimobakingapp.Adapter.RecipeMainAdapter;

/**
 * Created by ary on 9/17/17.
 */

public class MainStepsFragment extends Fragment {

    private RecyclerView mRecyclerview;
    private IngredientsAdapter myadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_steps, container, false);

        String getData = getArguments().getString("steps");

        mRecyclerview = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        mRecyclerview.setLayoutManager(llm);
        mRecyclerview.setAdapter(myadapter);

        return rootView;
    }
}
