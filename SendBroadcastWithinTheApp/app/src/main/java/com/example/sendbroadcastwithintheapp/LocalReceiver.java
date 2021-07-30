package com.example.sendbroadcastwithintheapp;

import android.content.Context;
import android.content.Intent;

public class LocalReceiver extends android.content.BroadcastReceiver {
    private String message;
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,SecondActivity.class);
        message = intent.getStringExtra("Message");
        intent1.putExtra("Message",message);
        context.startActivity(intent1);
    }
}
