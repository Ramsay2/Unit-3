package com.example.applecount;

import android.content.Context;
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
    private CommunicationListener listener;
    private FragmentManager fragmentManager;
    int number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;

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
        getParentFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getParentFragmentManager().getBackStackEntryCount() == 0){
                    if (getArguments()!= null){
                        number = getArguments().getInt("applesLeft");
                    }
                    mtvAppleLeft.setText(number +"");
                }
            }
        });
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = Integer.parseInt(metTotal.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("TotalApples",total);
                if (listener != null){
                    listener.launchBuyAppleFragment(bundle);
                }
            }
        });
        fragmentManager = requireActivity().getSupportFragmentManager();
    }

}