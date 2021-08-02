package com.example.dynamicfragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvText1, mTvText2;
    private ImageView mIvImage;

    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        mTvText1 = itemView.findViewById(R.id.tvTextView1);
        mTvText2 = itemView.findViewById(R.id.tvTextView2);
        mIvImage = itemView.findViewById(R.id.ivImage);

    }
    public void setData(ResponseDTO responseDTO){
        Glide.with(itemView).load(responseDTO.getImage()).placeholder(R.drawable.ic_launcher_background).into(mIvImage);
        mTvText1.setText(responseDTO.getTitle());
        mTvText2.setText(responseDTO.getSubTitle());
    }
}
