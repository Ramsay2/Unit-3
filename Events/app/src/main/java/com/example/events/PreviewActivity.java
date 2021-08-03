package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private TextView eventTitle, startDate, endDate, startTime, endTime, eventDesc, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initView();
        getData();
    }

    private void getData() {
        DataModel model = (DataModel) getIntent().getSerializableExtra("model");
        eventTitle.setText(model.getTitle());
        startDate.setText(model.getStartDate());
        endDate.setText(model.getEndDate());
        startTime.setText(model.getStartTime());
        endTime.setText(model.getEndTime());
        eventDesc.setText(model.getDesc());
        price.setText(model.getPrice());
    }

    private void initView() {
        eventTitle = findViewById(R.id.tvEventTitle);
        startDate = findViewById(R.id.tvStartDate);
        endDate = findViewById(R.id.tvEndDate);
        startTime = findViewById(R.id.tvStartTime);
        endTime = findViewById(R.id.tvEndTime);
        eventDesc = findViewById(R.id.tvEventDesc);
        price = findViewById(R.id.tvPrice);

    }
}