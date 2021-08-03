package com.example.events;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency, mEtPrice;
    private Button mBtnPreView;
    private String title, startDate, endDate, startTime, endTime, eventDesc;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("title");
            eventDesc = getArguments().getString("desc");
            startDate = getArguments().getString("startDate");
            endDate = getArguments().getString("endDate");
            startTime = getArguments().getString("startTime");
            endTime = getArguments().getString("endTime");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mEtPrice = view.findViewById(R.id.etPrice);
        mBtnPreView = view.findViewById(R.id.btnPreview);
        mBtnPreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currency = mEtCurrency.getText().toString();
                String price = mEtPrice.getText().toString();
                DataModel dataModel = new DataModel(title, eventDesc, startDate, endDate, startTime, endTime, price);
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("model", dataModel);
                startActivity(intent);
            }
        });
    }


}