package com.example.ary.mimobakingapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ary.mimobakingapp.Model.Ingredients;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;
import com.example.ary.mimobakingapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.MyViewHolder>{
    private final ArrayList<Ingredients> rvIngredients;
    private final ArrayList<Steps> rvSteps;

    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mIngredients;
        public TextView mSteps;

        public MyViewHolder(View view){
            super(view);
            mIngredients=(TextView) view.findViewById(R.id.txtIng);
            mSteps=(TextView) view.findViewById(R.id.recipeSteps);
        }
    }

    public MasterAdapter(Context context, ArrayList<Ingredients> rvIngredients, ArrayList<Steps> rvSteps) {
        this.rvIngredients = rvIngredients;
        this.rvSteps=rvSteps;
        this.context = context;
    }


    @Override
    public MasterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.master_layout_card, parent, false);
        return new MasterAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView myRecipeIngredients=holder.mIngredients;
        myRecipeIngredients.setText(rvIngredients.get(position).getIngredient());

        TextView myRecipeSteps=holder.mSteps;
        myRecipeSteps.
    }

    @Override
    public int getItemCount() {
        return rvIngredients.size();

    }



}

