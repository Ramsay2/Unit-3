package com.example.tiktok;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private VideoView videoView;
    private ProgressBar pbar;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.videoView);
        pbar = itemView.findViewById(R.id.progressBar);
    }

    public void setData(Model model) {
        videoView.setVideoURI(model.getUrl());
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pbar.setVisibility(View.GONE);
                mp.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
