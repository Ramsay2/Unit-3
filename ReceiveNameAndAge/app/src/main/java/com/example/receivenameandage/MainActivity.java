package com.example.receivenameandage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView tvName, tvAge;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    private String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mButton = findViewById(R.id.btnSend);
        registerLocal();
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.details.com");
                intent.putExtra("Name", "Sachin Sharma");
                intent.putExtra("Age", "23");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registerLocal() {
        Log.d("sharma", "Local it");
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.details.com");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    private class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("sharma", "received it");
            if (intent != null) {
                name = intent.getStringExtra("Name");
                age = intent.getStringExtra("Age");
                tvName.setText(name);
                tvAge.setText(age);
            }
        }
    }
}