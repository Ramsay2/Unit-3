package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener{
    private FragmentManager fragmentManager;
    private CommunicationListener communicationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchEventDetailsFragment();
    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragment.setCommunicationListener(this);
        fragmentTransaction.add(R.id.container, fragment, "eventDetails").commit();
    }

    @Override
    public void launchTimeAndDate(Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, timeAndDateFragment, "timeAndDateFragment").addToBackStack("").commit();
    }

    @Override
    public void launchPriceDetails(Bundle bundle1) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle1);
        fragmentTransaction.replace(R.id.container, priceDetailsFragment, "priceDetailsFragment").addToBackStack("").commit();
    }
}