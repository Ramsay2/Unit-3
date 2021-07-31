package com.example.sendbroadcastwithintheapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvMessage;
    private String message;
    private static final int CAMERA_CODE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTvMessage = findViewById(R.id.tvReceived);
        registerLocal();
    }
    private void registerLocal() {
        ActivityCompat.requestPermissions(
                SecondActivity.this,
                new String[]{Manifest.permission.CAMERA},
                CAMERA_CODE_REQUEST
        );
        message = getIntent().getStringExtra("Message");
        mTvMessage.setText(message);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalReceiver localReceiver = new LocalReceiver();
        unregisterReceiver(localReceiver);
    }
}