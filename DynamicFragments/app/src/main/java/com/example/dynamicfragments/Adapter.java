package com.example.dynamicfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ResponseDTO> responseList;

    public Adapter(List<ResponseDTO> responseList) {
        this.responseList = responseList;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ResponseDTO responseDTO = responseList.get(position);
        holder.setData(responseDTO);

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public void update(List<ResponseDTO> responseModels) {
        this.responseList = responseModels;
        notifyDataSetChanged();

    }
}
