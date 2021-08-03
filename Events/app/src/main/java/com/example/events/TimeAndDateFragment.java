package com.example.events;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TimeAndDateFragment extends Fragment implements CommunicationListener {
    private EditText metStartTime, metEndTime, metStartDate, metEndDate;
    private Button mBtnNext;
    private CommunicationListener listener;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = this.getArguments();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        metStartDate = view.findViewById(R.id.etStartDate);
        metEndDate = view.findViewById(R.id.etEndDate);
        metStartTime = view.findViewById(R.id.etStartTime);
        metEndTime = view.findViewById(R.id.etEndTime);
        mBtnNext = view.findViewById(R.id.btnTimeNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = metStartDate.getText().toString();
                String endDate = metEndDate.getText().toString();
                String startTime = metStartTime.getText().toString();
                String endTime = metEndTime.getText().toString();
                bundle.putString("startDate", startDate);
                bundle.putString("endDate", endDate);
                bundle.putString("startTime", startTime);
                bundle.putString("endTime", endTime);
                if (listener != null) {
                    listener.launchPriceDetails(bundle);
                }
            }
        });
    }

    public void setCommunicationListener(MainActivity communicationListener) {
        this.listener = communicationListener;
    }

    @Override
    public void launchTimeAndDate(Bundle bundle) {

    }

    @Override
    public void launchPriceDetails(Bundle bundle1) {

    }
}