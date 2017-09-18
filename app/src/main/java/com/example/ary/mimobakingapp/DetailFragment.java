package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ary on 9/17/17.
 */

public class DetailFragment extends Fragment {

    private TextView mTextView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.simple_exo_player_view, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textSteps);
        if (getArguments() != null) {
            String myDesc = getArguments().getString("mydesc");
            String myvideo= getArguments().getString("myvideourl");
            mTextView.setText(myDesc);


        }
        return rootView;
    }
}