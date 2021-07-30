package com.example.sendbroadcastwithintheapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNext;
    private LocalBroadcastManager localBroadcastManager;
    private static final int CAMERA_CODE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        btnNext = findViewById(R.id.btnNext);
        // sendBroadcast(intent, Manifest.permission.CAMERA);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.message.get");
                Log.d("sharma", "onClick it");
                intent.putExtra("Message", "Message received");
               localBroadcastManager.sendBroadcast(intent);
                Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent1);
            }
        });
    }

 /*   @Override
    protected void onResume() {
        super.onResume();
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CAMERA}, CAMERA_CODE_REQUEST);
    }
*/


}