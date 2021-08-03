package com.example.events;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventDetailsFragment extends Fragment implements CommunicationListener {
    private EditText mEtEventTitle, mEtEventDesc;
    private Button mBtnNext;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    private void initView(View view) {
        mEtEventTitle = view.findViewById(R.id.etTitle);
        mEtEventDesc = view.findViewById(R.id.etDescription);
        mBtnNext = view.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mEtEventTitle.getText().toString();
                String desc = mEtEventDesc.getText().toString();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", title);
                bundle1.putString("desc", desc);
                if (listener != null) {
                    listener.launchTimeAndDate(bundle1);
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