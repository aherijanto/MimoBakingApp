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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.simple_exo_player_view, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textSteps);


        if (getArguments() != null) {
            String myDesc = getArguments().getString("mydesc");
            String myvideo= getArguments().getString("myvideourl");
            mTextView.setText(myDesc);


                //BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                //TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
                //TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

                //LoadControl loadControl = new DefaultLoadControl();

                //player = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
                simpleExoPlayerView = new SimpleExoPlayerView(getActivity());
                simpleExoPlayerView = (SimpleExoPlayerView) rootView.findViewById(R.id.player);

                //simpleExoPlayerView.setUseController(true);
                //simpleExoPlayerView.requestFocus();

                //simpleExoPlayerView.setPlayer(player);

            Uri mp4VideoUri = Uri.parse(myvideo);
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            player = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
            simpleExoPlayerView.setPlayer(player);

            // Set the ExoPlayer.EventListener to this activity.
            //player.addListener((ExoPlayer.EventListener) getActivity().getApplicationContext());

            // Prepare the MediaSource.
            String userAgent = Util.getUserAgent(getActivity(), "mimobakingapp");
            MediaSource mediaSource = new ExtractorMediaSource(mp4VideoUri, new DefaultDataSourceFactory(
                    getActivity(), userAgent), new DefaultExtractorsFactory(), null, null);
            player.prepare(mediaSource);
            player.setPlayWhenReady(true);



            //player.setPlayWhenReady(true);
            //player.setVideoDebugListener((VideoRendererEventListener) getActivity().getApplicationContext());

        }
        return rootView;
    }



}
