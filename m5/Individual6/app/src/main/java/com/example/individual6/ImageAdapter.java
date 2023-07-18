package com.example.individual6;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.individual6.databinding.DataListItemBinding;

import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<ClipData.Item>itemList;


    public ImageAdapter(Context context, List<ClipData.Item>itemList){
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DataListItemBinding binding= DataListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        ClipData.Item descripcion= itemList.get(position);
        holder.textView.setText(descripcion.getText().toString());

        Glide.with(holder.imageView).load(descripcion.getHtmlText()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public TextView textView;
        public ImageViewHolder(DataListItemBinding binding){
            super(binding.getRoot());
            imageView=binding.imageView;
            textView=binding.textView;
        }
    }

}