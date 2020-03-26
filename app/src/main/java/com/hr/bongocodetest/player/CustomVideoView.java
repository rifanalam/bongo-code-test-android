package com.hr.bongocodetest.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created By Rifan on 26/3/20.
 */
public class CustomVideoView extends VideoView {
    public interface PlayPauseListener {
        void onPlay();
        void onVidPause();
        void forwardVideo();
        void rewindVideo();
    }

    private PlayPauseListener mListener;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int theme) {
        super(context, attrs, theme);
    }

    @Override
    public void pause() {
        super.pause();
        if (mListener != null) {
            mListener.onVidPause();
        }
    }

    @Override
    public void start() {
        super.start();
        if (mListener != null) {
            mListener.onPlay();
        }
    }

    public void setPlayPauseListener(PlayPauseListener listener) {
        mListener = listener;
    }

}