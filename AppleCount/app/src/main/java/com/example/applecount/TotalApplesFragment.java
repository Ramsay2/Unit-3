package com.example.applecount;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {
    private EditText metTotal;
    private TextView mtvAppleLeft;
    private Button mbtnNext;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        metTotal = view.findViewById(R.id.etTotalApples);
        mtvAppleLeft = view.findViewById(R.id.tvAppleLeft);
        mbtnNext = view.findViewById(R.id.btnNext);

        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = Integer.parseInt(metTotal.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("apple",total);
                replaceAWithB();
            }
        });
        fragmentManager = requireActivity().getSupportFragmentManager();
    }

    private void replaceAWithB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        transaction.replace(R.id.container, buyApplesFragment, "buyApplesFragment").commit();

    }

}