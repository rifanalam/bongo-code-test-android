package com.hr.bongocodetest.player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.net.Uri;
import android.os.Bundle;

import com.hr.bongocodetest.R;
import com.hr.bongocodetest.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity implements CustomVideoView.PlayPauseListener {
    ActivityPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        binding.videoView.setPlayPauseListener(this);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + R.raw.vid);
        binding.videoView.setVideoURI(videoUri);
        binding.videoView.start();
        binding.imageButtonPlayPause.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        controllerListener();
    }

    private void controllerListener() {
        binding.imageButtonRewind.setOnClickListener(view -> {
            rewindVideo();
        });
        binding.imageButtonPlayPause.setOnClickListener(view -> {
            if (binding.videoView.isPlaying()) {
                binding.videoView.pause();
            } else {
                binding.videoView.start();
            }
        });
        binding.imageButtonForword.setOnClickListener(view -> {
            forwardVideo();
        });
    }

    @Override
    public void onBackPressed() {
        if (binding.videoView.isPlaying()) {
            binding.videoView.stopPlayback();
        }
        super.onBackPressed();
    }

    @Override
    public void forwardVideo() {
        int pos = binding.videoView.getCurrentPosition();
        pos += 15000; // milliseconds
        if (binding.videoView.getDuration() >= pos)
            binding.videoView.seekTo(pos);
    }

    @Override
    public void rewindVideo() {
        int pos = binding.videoView.getCurrentPosition();
        pos -= 5000; // milliseconds
        if (pos >= 0)
            binding.videoView.seekTo(pos);
    }

    @Override
    public void onPlay() {
        binding.imageButtonPlayPause.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
    }

    @Override
    public void onVidPause() {
        binding.imageButtonPlayPause.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
    }
}
