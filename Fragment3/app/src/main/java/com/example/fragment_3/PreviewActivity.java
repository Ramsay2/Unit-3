package com.example.fragment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvName, mTvAge, mTvGrade, mTvPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initView();
        getData();
    }

    private void initView() {
        mTvName = findViewById(R.id.tvStudentName);
        mTvAge = findViewById(R.id.tvStudentAge);
        mTvGrade = findViewById(R.id.tvStudentGrade);
        mTvPer = findViewById(R.id.tvStudentPercentage);
    }

    private void getData() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        mTvName.setText(model.getName());
        mTvAge.setText(model.getAge() + "");
        mTvGrade.setText(model.getGrade());
        mTvPer.setText(model.getPer());
    }
}