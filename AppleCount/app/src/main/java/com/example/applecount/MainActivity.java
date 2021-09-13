package com.example.applecount;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;
    private TotalApplesFragment totalApplesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchTotalApple();
    }

    private void launchTotalApple() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        totalApplesFragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.container, totalApplesFragment, "totalApple").commit();
    }

    @Override
    public void launchBuyAppleFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, buyApplesFragment, "buyApple").addToBackStack("BuyApplesFragment").commit();

    }

    @Override
    public void sendApplesData(Bundle bundle) {
        totalApplesFragment.setArguments(bundle);
    }
}