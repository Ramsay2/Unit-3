package com.example.threadsloopersandhandlers;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread {
    private Handler handler;
private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    public void run() {

        Looper.prepare();
        handler = new Handler(Looper.myLooper());

        Looper.loop();

    }

    public void addTaskToQueue(Runnable task) {
        if (handler != null) {
            handler.post(task);
        }

    }


}
