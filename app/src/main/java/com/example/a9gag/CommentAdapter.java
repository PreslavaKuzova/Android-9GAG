package com.example.a9gag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentAdapter extends RecyclerView.Adapter<CommentItemViewHolder> {
    @NonNull
    @Override
    public CommentItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CommentItemViewHolder holder = new CommentItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentItemViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
