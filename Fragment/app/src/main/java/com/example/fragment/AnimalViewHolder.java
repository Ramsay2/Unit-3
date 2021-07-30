package com.example.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AnimalViewHolder  extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private ImageView mIvAnimal;


    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        mTvName = itemView.findViewById(R.id.tvName);
        mIvAnimal = itemView.findViewById(R.id.ivAnimals);
    }
    public void setData(Animal animal){
        mTvName.setText(animal.getName());
        mIvAnimal.setImageResource(animal.getImageId());
    }
}
