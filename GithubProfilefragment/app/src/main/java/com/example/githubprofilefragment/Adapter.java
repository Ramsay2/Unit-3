package com.example.githubprofilefragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ResponseDTO> modelList;

    public Adapter(List<ResponseDTO> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponseDTO responseModel = modelList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public void update(List<ResponseDTO> responseModels){
        this.modelList = responseModels;
        notifyDataSetChanged();

    }
}
