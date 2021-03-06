package com.example.ary.mimobakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ary.mimobakingapp.DetailActivity;
import com.example.ary.mimobakingapp.MainActivitySteps;
import com.example.ary.mimobakingapp.MainStepsFragment;
import com.example.ary.mimobakingapp.Model.Recipe;
import com.example.ary.mimobakingapp.Model.Steps;
import com.example.ary.mimobakingapp.R;

import java.util.ArrayList;

/**
 * Created by ary on 9/17/17.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {

    private ArrayList<Steps> msteps;


    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView shortDesc;
        public TextView desc;
        public TextView videoURL;
        public ImageView videoThumbnail;



        public MyViewHolder(View view){
            super(view);
            shortDesc=(TextView) view.findViewById(R.id.shortdesc);
            desc=(TextView) view.findViewById(R.id.desc);
            videoURL=(TextView) view.findViewById(R.id.video_url);
            videoThumbnail=(ImageView) view.findViewById(R.id.videothumb);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        Steps clickedStep=msteps.get(pos);
                        String myDesc=clickedStep.getDescription();
                        String myVideo=clickedStep.getVideoURL();

                        Intent intent=new Intent(context, DetailActivity.class);

                        intent.putExtra("desc",myDesc );
                        intent.putExtra("videoUrl",myVideo);

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }
                }

            });
        }
    }


    public IngredientsAdapter(Context context, ArrayList<Steps> mySteps) {
        this.msteps=mySteps;
        this.context = context;
    }


    @Override
    public IngredientsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.steps_card, parent, false);
        return new IngredientsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IngredientsAdapter.MyViewHolder holder, int position) {
        TextView myshort=holder.shortDesc;
        myshort.setText(msteps.get(position).getShortDescription());

        TextView mydesc=holder.desc;
        mydesc.setText(msteps.get(position).getDescription());

        TextView myvideoURL=holder.videoURL;
        myvideoURL.setText(msteps.get(position).getVideoURL());

        Glide.with(context)
                .load(msteps.get(position).getThumbnailURL())
                .placeholder(R.drawable.vidthumb)
                .into(holder.videoThumbnail);


    }

    @Override
    public int getItemCount() {
        return msteps.size();
    }

}

