package com.example.ary.mimobakingapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlaybackControlView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;

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
        simpleExoPlayerView=(SimpleExoPlayer) rootView.findViewById(R.id.player);

        if (getArguments() != null) {
            String myDesc = getArguments().getString("mydesc");
            String myvideo= getArguments().getString("myvideourl");
            mTextView.setText(myDesc);

            Handler mainHandler = new Handler();
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelection.Factory videoTrackSelectionFactory =
                    new AdaptiveTrackSelection.Factory(bandwidthMeter);
            TrackSelector trackSelector =
                    new DefaultTrackSelector(videoTrackSelectionFactory);


            SimpleExoPlayer player =
                    ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector);

            simpleExoPlayerView.setPlayer(player);



        }
        return rootView;
    }
}