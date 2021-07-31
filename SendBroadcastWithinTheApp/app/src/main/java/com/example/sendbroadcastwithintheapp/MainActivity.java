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
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNext;
    private LocalReceiver localReceiver = new LocalReceiver();
    private static final int CAMERA_CODE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btnNext);
        registerReceiver();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.message.com");
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        CAMERA_CODE_REQUEST
                );
                intent.putExtra("Message", "Message received");
                sendBroadcast(intent, Manifest.permission.CAMERA);
            }
        });
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter("com.message.com");
        registerReceiver(localReceiver, intentFilter);
    }



}

