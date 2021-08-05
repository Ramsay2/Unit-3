package com.example.threadsloopersandhandlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mbtn1, mbtn2;
    private WorkerThread workerThread;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        workerThread.start();
        mbtn1 = findViewById(R.id.btnButton1);
        mbtn2 = findViewById(R.id.btnButton2);
        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQueue(task1);
            }
        });
        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQueue(task2);
            }
        });

    }

    private Runnable task1 = new Runnable() {

        @Override
        public void run() {

            Log.d(TAG, "task1" + Thread.currentThread().getName());
            try {

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable task2 = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task2" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}