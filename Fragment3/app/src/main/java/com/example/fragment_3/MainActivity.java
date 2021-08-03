package com.example.fragment_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;
    private CommunicationListener communicationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchStudentPersonalFragment();
    }

    private void launchStudentPersonalFragment() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment fragment = new StudentPersonalDetailsFragment();
        fragment.setCommunicationListener(this);
        fragmentTransaction.add(R.id.container, fragment, "personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment performanceDetailsFragment = new StudentPerformanceDetailsFragment();
        performanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, performanceDetailsFragment, "personalDetailsFragment").addToBackStack("").commit();
    }
}