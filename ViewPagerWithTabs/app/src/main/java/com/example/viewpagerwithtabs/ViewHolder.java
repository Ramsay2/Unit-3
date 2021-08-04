package com.example.viewpagerwithtabs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tvData;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvData = itemView.findViewById(R.id.tvData);
    }
    public void setName(Data data){
        tvData.setText(data.getName());

    }
    public void setPlace(Data data){

        tvData.setText(data.getPlace());

    }
    public void setTourist(Data data){
        tvData.setText(data.getTouristPlace());
    }
}
