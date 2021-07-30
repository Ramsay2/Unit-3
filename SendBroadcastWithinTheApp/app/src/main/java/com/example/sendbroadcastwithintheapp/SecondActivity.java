package com.example.sendbroadcastwithintheapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

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
    private LocalReceiver localReceiver ;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mTvMessage = findViewById(R.id.tvReceived);
        registerLocal();
        Log.d("sharma", "Second it");
    }


    private void registerLocal() {
        Log.d("sharma", "Local it");
            localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.message.get");
       // registerReceiver(localReceiver, intentFilter);
       localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }


    private class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
                Log.d("sharma", "received it");
                message = intent.getStringExtra("Message");
                mTvMessage.setText(message);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }
}