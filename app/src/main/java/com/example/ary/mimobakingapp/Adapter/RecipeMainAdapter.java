package com.example.ary.mimobakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ary.mimobakingapp.MasterFragment;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.R;

import java.util.ArrayList;

/**
 * Created by ary on 9/15/17.
 */

public class RecipeMainAdapter extends RecyclerView.Adapter<RecipeMainAdapter.MyViewHolder>{


    private final ArrayList<Recipe> rvRecipeList;

    Context context;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView recipeName;


        public MyViewHolder(View view){
            super(view);
            recipeName=(TextView) view.findViewById(R.id.recipename);


            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        Recipe clickeddataItem= rvRecipeList.get(pos);
                        Intent intent=new Intent(context,MasterFragment.class);
                        intent.putExtra("ingredients",rvRecipeList.get(pos).getIngredients());
                        //intent.putExtra("poster_path",movieList.get(pos).getPosterpath());
                        //intent.putExtra("overview",movieList.get(pos).getOverview());
                        //intent.putExtra("vote_average",Double.toString(movieList.get(pos).getVoteAverage()));
                        //intent.putExtra("id",movieList.get(pos).getId());
                        //intent.putExtra("release_date",movieList.get(pos).getReleasedate());
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //mContext.startActivity(intent);
                        //Toast.makeText(v.getContext(),clickeddataItem.getOriginaltitle(),Toast.LENGTH_SHORT).show();
                    }
                }






            });

        }
    }


    public RecipeMainAdapter(Context context, ArrayList<Recipe> rvRecipeList) {
        this.rvRecipeList = rvRecipeList;
        this.context = context;
    }


    @Override
    public RecipeMainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_main_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView myRecipeName=holder.recipeName;
        myRecipeName.setText(rvRecipeList.get(position).getName());
        //String vote=Double.toString(rvRecipeList.get(position).getVoteAverage());
        //viewHolder.userrating.setText(vote);
    }

    @Override
    public int getItemCount() {
        return rvRecipeList.size();
    }



    }

