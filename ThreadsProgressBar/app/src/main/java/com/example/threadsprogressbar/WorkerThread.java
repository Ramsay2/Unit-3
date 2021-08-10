package com.example.threadsprogressbar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerThread extends HandlerThread {
    private Handler handler;

    public WorkerThread(String name, Handler handler) {
        super(name);
        this.handler = handler;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int process = 10;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                process = process + 10;
                Message message = Message.obtain();
                message.obj = process;
                handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
