package com.example.ary.mimobakingapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ary.mimobakingapp.Model.RecipeMain;
import com.example.ary.mimobakingapp.R;

import java.util.ArrayList;

/**
 * Created by ary on 9/14/17.
 */

public class RecipeMainAdapter extends RecyclerView.Adapter<RecipeMainAdapter.ViewHolder>

{

    private ArrayList<RecipeMain> recipeMainArrayList;

    public RecipeMainAdapter(ArrayList<RecipeMain> recipeMainArrayList) {
        this.recipeMainArrayList = recipeMainArrayList;
    }

    @Override
    public RecipeMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_main_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeMainAdapter.ViewHolder holder, int position) {
        holder.card_recipeName.setText(recipeMainArrayList.get(position).getRecipeName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView card_recipeName;
        public ViewHolder(View view) {
            super(view);

           card_recipeName = (TextView)view.findViewById(R.id.recipename);


        }
    }
}
