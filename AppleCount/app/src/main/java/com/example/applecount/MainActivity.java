package com.example.applecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;
    private CommunicationListener communicationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchTotalApple();
    }

    private void launchTotalApple() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment fragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.container, fragment, "totalApple").addToBackStack("fragment").commit();
    }

    @Override
    public void launchTotalApple(Bundle bundle) {
        

    }
}