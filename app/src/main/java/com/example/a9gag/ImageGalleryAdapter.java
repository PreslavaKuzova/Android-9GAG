package com.example.a9gag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {

    private List<ImageItem> images;
    private ImageItemButtonsClickListener listener;

    public ImageGalleryAdapter(List<ImageItem> images, ImageItemButtonsClickListener listener) {
        this.images = images;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        ImageItemViewHolder holder = new ImageItemViewHolder(v, this.listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageItemViewHolder holder, int position) {
        ImageItem item = images.get(position);
        holder.img.setImageResource(item.imgResource);
        holder.txtDescription.setText(item.description);
        holder.txtPoints.setText(String.valueOf(item.points));
        holder.txtComments.setText(String.valueOf(item.comments));
        holder.btnUp.setEnabled(!item.isButtonUpPressed);
        holder.btnDown.setEnabled(!item.isButtonDownPressed);
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
