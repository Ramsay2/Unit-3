package com.example.viewpagerwithtabs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {
private ArrayList<Data> dataList;
private int fragment;

    public Adapter(ArrayList<Data> dataList, int fragment) {
        this.dataList = dataList;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Data data = dataList.get(position);
    switch (fragment){
        case 0:
            holder.setName(data);
            return;
        case 1:
            holder.setPlace(data);
            return;
        case 2:
            holder.setTourist(data);
    }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
