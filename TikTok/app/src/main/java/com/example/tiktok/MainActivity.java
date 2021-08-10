package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private ArrayList<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager2 = findViewById(R.id.viewPager);
        models = new ArrayList<>();
        String path = "android.resource://" + getPackageName()+"/" + R.raw.video__;
        Uri uri = Uri.parse(path);
        Model video1 = new Model(uri);
        models.add(video1);
        String path1 = "android.resource://" + getPackageName()+"/" + R.raw.short_video;
        Uri uri1 = Uri.parse(path1);
        Model video2 = new Model(uri1);
        models.add(video2);
        Model video3 = new Model(uri);
        models.add(video3);
        Model video4 = new Model(uri1);
        models.add(video4);
        Model video5 = new Model(uri);
        models.add(video5);
        viewPager2.setAdapter(new Adapter(models));
    }
}