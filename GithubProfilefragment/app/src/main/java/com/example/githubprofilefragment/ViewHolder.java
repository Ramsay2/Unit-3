package com.example.githubprofilefragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvName, mtvId;
    private ImageView mivImage;

    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        mtvName = itemView.findViewById(R.id.tvName);
        mtvId = itemView.findViewById(R.id.tvID);
        mivImage = itemView.findViewById(R.id.ivImage);
    }

    public void setData(ResponseDTO responseDTO) {

        mtvName.setText(responseDTO.getName());
        mtvId.setText(responseDTO.getNodeId());
        Glide.with(itemView).load(responseDTO.getUrl()).placeholder(R.drawable.ic_launcher_background).into(mivImage);
    }
}
