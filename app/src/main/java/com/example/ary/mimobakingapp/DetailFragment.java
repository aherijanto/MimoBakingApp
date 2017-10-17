package com.example.ary.mimobakingapp;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/**
 * Created by ary on 9/17/17.
 */

public class DetailFragment extends Fragment {

    private TextView mTextView;
    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer player;
    public Long position;
    public String myvideo;
    public String myDesc;
    private static final String MY_KEY_DESC="com.example.ary.mimobakingapp.my_key_desc";
    private static final String MY_KEY_VIDEO="com.example.ary.mimobakingapp.my_key_video";
    private static final String MY_KEY_POST="com.example.ary.mimobakingapp.my_key_pos";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.simple_exo_player_view, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textSteps);

        if (getArguments() != null) {
            int position = getArguments().getInt("ARGUMENTS", -1);
            myDesc = getArguments().getString("mydesc");
            myvideo= getArguments().getString("myvideourl");
            mTextView.setText(myDesc);

            simpleExoPlayerView = new SimpleExoPlayerView(getActivity());
            simpleExoPlayerView = (SimpleExoPlayerView) rootView.findViewById(R.id.player);

            settingPlayer(Uri.parse(myvideo));

        }
        return rootView;

    }

    public void settingPlayer(Uri myMedia) {
    if (player == null) {

        TrackSelector trackSelector = new DefaultTrackSelector();
        LoadControl loadControl = new DefaultLoadControl();
        player = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
        simpleExoPlayerView.setPlayer(player);


        String userAgent = Util.getUserAgent(getActivity(), "mimobakingapp");
        MediaSource mediaSource = new ExtractorMediaSource(myMedia, new DefaultDataSourceFactory(getActivity(), userAgent), new DefaultExtractorsFactory(), null, null);
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }
}


    @Override
    public void onPause() {
        super.onPause();
        if (player!=null) {
            position = player.getCurrentPosition();
            player.stop();
            player.release();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (myvideo != null){
            settingPlayer(Uri.parse(myvideo));}

    }
//-------Save and restore in Fragment
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putString(MY_KEY_DESC,myDesc);
        currentState.putString(MY_KEY_VIDEO,myvideo);
        currentState.putLong(MY_KEY_POST,position);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState!=null) {
            myDesc = savedInstanceState.getString(MY_KEY_DESC);
            myvideo = savedInstanceState.getString(MY_KEY_VIDEO);
            position = savedInstanceState.getLong(MY_KEY_POST);
        }
    }

}


